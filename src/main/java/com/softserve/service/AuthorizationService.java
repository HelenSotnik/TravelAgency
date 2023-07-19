package com.softserve.service;

import com.softserve.config.WebAuthenticationToken;
import com.softserve.model.Booking;
import com.softserve.model.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;


@Service
public class AuthorizationService {

    private final BookingService bookingService;

    public AuthorizationService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public boolean isOwnerByBookingId(long bookingId) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        User user = (User)securityContext.getAuthentication().getDetails();

        Booking booking = bookingService.getBooking(bookingId);
        return user.getId() == booking.getGuest().getId();
    }

    public boolean isOwnerByUserId(long userId) {
        WebAuthenticationToken authentication = (WebAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getDetails();
        return bookingService.getBookingsByUserId(userId)
                .stream()
                .anyMatch((booking) -> booking.getGuest().getId() == user.getId());
    }
}
