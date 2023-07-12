package com.softserve.controller;


import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;
import com.softserve.service.HotelService;
import com.softserve.service.RoomService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/{hotelId}/book/{roomId}")
    public String bookRoom(@PathVariable("hotelId") long hotelId, @PathVariable("roomId") long roomId, Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("roomId", roomId);
        return "booking-form";
    }

    @PostMapping("/{hotelId}/book/{roomId}")
    public String bookRoom(@PathVariable("hotelId") long hotelId, @PathVariable("roomId") long roomId,
                           @ModelAttribute("booking") Booking booking) {
        Room room = roomService.readById(roomId);
        User user = userService.getUserByEmail(booking.getGuestEmail());
        Hotel hotel = hotelService.readById(hotelId);
        booking.setRoom(room);
        booking.setGuest(user);
        booking.setHotel(hotel);
        hotelService.bookRoom(booking);
        return "redirect:/users/welcome";
    }

    @GetMapping("/{userId}")
    public String getUserBookings(@PathVariable long userId, Model model) {
        List<Booking> bookings = hotelService.getBookingsByUserId(userId);
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }

    @GetMapping("/{bookingId}/delete")
    public String cancelBooking(@PathVariable("bookingId") int bookingId) {
        hotelService.cancelBooking(bookingId);
        return "welcome-page";
    }

    @GetMapping("/{bookingId}/update")
    public String updateBooking(@PathVariable("bookingId") int bookingId, Model model) {
        Booking booking = hotelService.getBooking(bookingId);
        model.addAttribute("booking", booking);
        return "update-booking";
    }
}
