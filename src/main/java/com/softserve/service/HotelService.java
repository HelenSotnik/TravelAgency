package com.softserve.service;

import com.softserve.exception.NullEntityReferenceException;
import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.repository.BookingRepository;
import com.softserve.repository.HotelRepository;
import com.softserve.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

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
        List<Booking> bookingsInRange = new ArrayList<>();

        Period period = Period.ofDays(1);
        LocalDate currentDate = checkInDate;

        while (!currentDate.isAfter(checkOutDate)) {
            bookingsInRange.addAll( bookingRepository.findBookingsByDateInRange(hotelId,currentDate));
            currentDate = currentDate.plus(period);
        }

        if (bookingsInRange.size() != 0) {
            for (Booking b : bookingsInRange) {
                allHotelRooms.remove(b.getRoom());
            }
        }
        return allHotelRooms;
    }
}
