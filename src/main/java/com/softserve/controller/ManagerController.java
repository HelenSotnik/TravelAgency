package com.softserve.controller;

import com.softserve.dto.RoleResponse;
import com.softserve.model.User;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class ManagerController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
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

    @GetMapping("/roles")
    public List<RoleResponse> listRoles() {
        return userService.getAllRoles();
    }
}
