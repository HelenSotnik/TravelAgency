package com.softserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/accessDenied")
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("error",
                    "Unfortunately, " +
                            "you do not have permission to view this page!");
        }
        model.setViewName("accessDenied");
        return model;
    }
}

