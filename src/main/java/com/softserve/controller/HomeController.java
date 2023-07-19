package com.softserve.controller;

import com.softserve.model.Hotel;
import com.softserve.service.HotelService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;
    private final HotelService hotelService;

    @Autowired
    public HomeController(UserService userService, HotelService hotelService) {
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER')")
    @GetMapping("/")
    public String userHome(Model model) {
        List<Hotel> hotels = hotelService.getAll();
        model.addAttribute("hotels", hotels);
        return "home";
    }
}
