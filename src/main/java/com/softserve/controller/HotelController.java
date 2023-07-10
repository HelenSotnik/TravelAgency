package com.softserve.controller;

import com.softserve.model.Hotel;
import com.softserve.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}