package com.softserve.controller;

import com.softserve.model.User;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView home() {
        List<User> list = userService.getAll();
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("users", list);
        return modelAndView;
    }
}
