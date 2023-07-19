package com.softserve.controller;

import com.softserve.model.Hotel;
import com.softserve.model.Room;
import com.softserve.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "create-hotel";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("hotel") Hotel hotel, BindingResult result) {
        if (result.hasErrors()) {
            return "create-hotel";
        }
        hotelService.create(hotel);
        return "redirect:/hotels";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER')")
    @GetMapping("/{hotelId}/read")
    public String read(@PathVariable long hotelId, Model model) throws EntityNotFoundException {
        Hotel hotel = hotelService.readById(hotelId);
        model.addAttribute("hotel", hotel);
        return "hotel-info";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        Hotel hotel = hotelService.readById(id);
        model.addAttribute("hotel", hotel);
        return "edit-hotel";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) throws EntityNotFoundException {
        hotelService.delete(id);
        return "redirect:/hotels";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER')")
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("hotels", hotelService.getAll());
        return "hotels";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER')")
    @RequestMapping("/search-hotel")
    public String search(@RequestParam String keyword, Model model) {
        List<Hotel> result = hotelService.searchHotel(keyword);
        model.addAttribute("result", result);
        return "search-hotel";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER')")
    @GetMapping("/{hotelId}/check-rooms")
    public String checkAvailableRooms(@PathVariable("hotelId") long id, @RequestParam String checkInDate,
                                      @RequestParam String checkOutDate, Model model) {
        List<Room> result = hotelService.searchAvailableRooms(
                LocalDate.parse(checkInDate), LocalDate.parse(checkOutDate), id);
        Hotel hotel = hotelService.readById(id);
        model.addAttribute("hotel", hotel);
        model.addAttribute("result", result);
        return "rooms-result";
    }
}
