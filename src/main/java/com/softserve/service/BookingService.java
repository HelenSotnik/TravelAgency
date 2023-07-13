package com.softserve.service;

import com.softserve.exception.NullEntityReferenceException;
import com.softserve.model.Booking;
import com.softserve.model.Room;
import com.softserve.model.User;
import com.softserve.repository.BookingRepository;
import com.softserve.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    public void bookRoom(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking getBooking(long id) {
        return bookingRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Booking with id " + id + " not found"));
    }

    public List<Booking> getBookingsByUserId(long id) {
        User guest = userService.readById(id);
        return bookingRepository.findBookingsByGuestEmail(guest.getEmail());
    }

    public void cancelBooking(long id) {
        bookingRepository.deleteBookingById(id);
    }

    public Booking updateBooking(Booking booking) {
        if (booking != null) {
            getBooking(booking.getId());
            return bookingRepository.save(booking);
        }
        throw new NullEntityReferenceException("Booking cannot be 'null'");
    }
}
