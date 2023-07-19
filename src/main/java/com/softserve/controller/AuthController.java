package com.softserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class AuthController {

    @GetMapping("/login-form")
    public String login() {
        return "login-form";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {

            model.addObject("message", "Sorry, you do not have permission to view this page!");
        }
        model.setViewName("accessDenied");
        return "accessDenied";
    }
}


