package com.softserve.controller;

import com.softserve.model.Booking;
import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.model.User;
import com.softserve.service.HotelService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "create-hotel";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("hotel") Hotel hotel, BindingResult result) {
        if (result.hasErrors()) {
            return "create-hotel";
        }
        hotelService.create(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/{hotelId}/read")
    public String read(@PathVariable long hotelId, Model model) {
        Hotel hotel = hotelService.readById(hotelId);
        model.addAttribute("hotel", hotel);
        return "hotel-info";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        Hotel hotel = hotelService.readById(id);
        model.addAttribute("hotel", hotel);
        return "edit-hotel";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        hotelService.delete(id);
        return "redirect:/hotels";
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("hotels", hotelService.getAll());
        return "hotels";
    }

    @RequestMapping("/search-hotel")
    public String search(@RequestParam String keyword, Model model) {
        List<Hotel> result = hotelService.searchHotel(keyword);
        model.addAttribute("result", result);
        return "search-hotel";
    }

    @GetMapping("/{hotelId}/check-rooms")
    public String checkAvailableRooms(@PathVariable("hotelId") long id, @RequestParam String checkInDate,
                                      @RequestParam String checkOutDate, Model model) {
        List<Room> result = hotelService.searchAvailableRooms(
                LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate), id);
        Hotel hotel =hotelService.readById(id);
        model.addAttribute("hotel", hotel);
        model.addAttribute("result", result);
        return "rooms-result";
    }

    @GetMapping("/{hotelId}/book/{roomId}")
    public String bookRoom(@PathVariable long hotelId, @PathVariable long roomId, Model model){
        model.addAttribute("hotel", hotelService.readById(hotelId));
        model.addAttribute("room", hotelService.getHotelRoomById(roomId));
        model.addAttribute("booking", new Booking());
        return "booking-form";
    }

    @PostMapping("/{hotelId}/book/{roomId}")
    public String bookRoom(@PathVariable long hotelId, @PathVariable long roomId,
                           @ModelAttribute("booking") Booking booking, Model model){
        model.addAttribute("hotel", hotelService.readById(hotelId));
        model.addAttribute("room", hotelService.getHotelRoomById(roomId));
        model.addAttribute("booking", booking);
        hotelService.bookHotel(hotelId,roomId,booking);
        return "bookings-list";
    }

//    @PostMapping("/cancel/{bookingId}")
//    public String cancelBooking(@PathVariable("bookingId") int bookingId, Model model) {
//        hotelService.cancelBooking(bookingId);
//        return "cancellation-confirmation";
//    }
//
//    @GetMapping("/update/{bookingId}")
//    public String updateBooking(@PathVariable("bookingId") int bookingId, Model model) {
//        Booking booking = hotelService.getBooking(bookingId);
//        model.addAttribute("booking", booking);
//        return "update-booking";
//    }
}
