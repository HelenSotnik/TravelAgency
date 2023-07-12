package com.softserve.service;

import com.softserve.exception.NullEntityReferenceException;
import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;
import com.softserve.repository.BookingRepository;
import com.softserve.repository.HotelRepository;
import com.softserve.repository.RoomRepository;
import com.softserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;


    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel readById(long id) {
        return hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Hotel with id " + id + " not found"));
    }

    public Hotel update(Hotel hotel) {
        if (hotel != null) {
            readById(hotel.getId());
            return hotelRepository.save(hotel);
        }
        throw new NullEntityReferenceException("Hotel cannot be 'null'");
    }

    public void delete(long id) {
        hotelRepository.delete(readById(id));
    }

    public List<Hotel> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.isEmpty() ? new ArrayList<>() : hotels;
    }

    public List<Hotel> searchHotel(String keyword) {
        List<Hotel> hotels = hotelRepository.searchHotel(keyword);
        return hotels.isEmpty() ? new ArrayList<>() : hotels;
    }

    public List<Room> searchAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, long hotelId) {
        List<Room> allHotelRooms = roomRepository.findRoomsByHotel_Id(hotelId);

        List<Booking> bookingsByDateInRange =
                bookingRepository.findByDateInRange(checkInDate, checkOutDate)
                        .stream()
                        .filter(booking -> booking.getHotel().getId() == hotelId)
                        .collect(Collectors.toList());

        if (bookingsByDateInRange.size() != 0) {
            for (Booking b : bookingsByDateInRange) {
                allHotelRooms.remove(b.getRoom());
            }
        }
        return allHotelRooms;
    }

    public Room getHotelRoomById(long id) {
        return roomRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room with id " + id + " not found"));
    }

    public void bookRoom(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking getBooking(long id) {
        return bookingRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Booking with id " + id + " not found"));
    }

    public List<Booking> getBookingsByUserId(long id){
        User guest = userService.readById(id);
        return bookingRepository.findBookingsByGuestEmail(guest.getEmail());
    }

    public void cancelBooking(long id) {
        bookingRepository.deleteBookingById(id);
    }
}
