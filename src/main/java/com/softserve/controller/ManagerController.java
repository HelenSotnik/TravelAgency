package com.softserve.controller;

import com.softserve.model.Hotel;
import com.softserve.model.User;
import com.softserve.service.HotelService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('MANAGER')")
@RequestMapping("/agency-manager")
public class ManagerController {

    private final UserService userService;
    private final HotelService hotelService;

    @Autowired
    public ManagerController(UserService userService, HotelService hotelService) {
        this.userService = userService;
        this.hotelService = hotelService;
    }


    @GetMapping
    public String managerHome(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("users", list);
        return "manager";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<User> result = userService.search(keyword);
        model.addAttribute("result", result);
        return "search";
    }

    @GetMapping("/hotels/{hotelId}/read")
    public String read(@PathVariable long hotelId, Model model) throws EntityNotFoundException {
        Hotel hotel = hotelService.readById(hotelId);
        model.addAttribute("hotel", hotel);
        return "hotel-info-manager";
    }
}
