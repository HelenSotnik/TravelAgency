package com.softserve.controller;


import com.softserve.dto.BookingDto;
import com.softserve.dto.BookingTransformer;
import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;
import com.softserve.service.BookingService;
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

    private final HotelService hotelService;
    private final UserService userService;
    private final RoomService roomService;
    private final BookingService bookingService;

    @Autowired
    public BookingController(HotelService hotelService, UserService userService, RoomService roomService,
                             BookingService bookingService) {
        this.hotelService = hotelService;
        this.userService = userService;
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    @GetMapping("/{hotelId}/book/{roomId}")
    public String bookRoom(@PathVariable long hotelId, @PathVariable long roomId, Model model) {
        model.addAttribute("booking", new BookingDto());
        model.addAttribute("hotelId", hotelId);
        model.addAttribute("roomId", roomId);
        return "booking-form";
    }

    @PostMapping("/{hotelId}/book/{roomId}")
    public String bookRoom(@PathVariable long hotelId, @PathVariable long roomId,
                           @ModelAttribute("booking") BookingDto bookingDto, Model model) {
        Room room = roomService.readById(roomId);
        User user = userService.getUserByEmail(bookingDto.getGuestEmail());
        Hotel hotel = hotelService.readById(hotelId);

        Booking booking = BookingTransformer.convertToEntity(bookingDto, room, user, hotel);
        bookingService.bookRoom(booking);
        model.addAttribute("userId", user.getId());
        return "redirect:/bookings/{userId}";
    }

    @GetMapping("/{userId}")
    public String getUserBookings(@PathVariable long userId, Model model) {
        List<Booking> bookings = bookingService.getBookingsByUserId(userId);
        User user = userService.readById(userId);
        model.addAttribute("user", user);
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }

    @GetMapping("/{bookingId}/delete")
    public String cancelBooking(@PathVariable int bookingId, Model model) {
        Booking booking = bookingService.getBooking(bookingId);
        bookingService.cancelBooking(bookingId);
        model.addAttribute("userId", booking.getGuest().getId());
        return "redirect:/bookings/{userId}";
    }
}
