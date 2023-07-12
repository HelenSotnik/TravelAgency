package com.softserve.dto;

import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;

import java.time.LocalDate;

public class BookingTransformer {
    public static BookingDto convertToDto(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getGuestFullName(),
                booking.getGuestEmail(),
                booking.getCheckInDate().toString(),
                booking.getCheckOutDate().toString(),
                booking.getRoom().getId(),
                booking.getGuest().getId(),
                booking.getHotel().getId()
        );
    }
    public static Booking convertToEntity(BookingDto bookingDto, Room room, User guest, Hotel hotel){
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setGuestFullName(bookingDto.getGuestFullName());
        booking.setGuestEmail(bookingDto.getGuestEmail());
        booking.setCheckInDate(LocalDate.parse(bookingDto.getCheckInDate()));
        booking.setCheckOutDate(LocalDate.parse(bookingDto.getCheckOutDate()));
        booking.setRoom(room);
        booking.setGuest(guest);
        booking.setHotel(hotel);
        return booking;
    }
}
