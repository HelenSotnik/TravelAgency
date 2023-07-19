package com.softserve.service;

import com.softserve.model.Booking;
import com.softserve.model.User;
import com.softserve.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void cancelBooking(long id) {
        bookingRepository.deleteBookingById(id);
    }
}
