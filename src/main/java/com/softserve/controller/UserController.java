package com.softserve.controller;

import com.softserve.dto.RoleResponse;
import com.softserve.dto.UserDto;
import com.softserve.dto.UserTransformer;
import com.softserve.model.Role;
import com.softserve.model.User;
import com.softserve.service.RoleService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/manager/roles")
    public List<RoleResponse> listRoles() {
        return userService.getAllRoles();
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        user.setPassword(user.getPassword());
        user.setRole(roleService.getByRoleName("USER"));
        userService.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable long id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/{userid}/update")
    public String update(@PathVariable long userid, Model model) {
        User user = userService.readById(userid);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAll());
        return "update";
    }

    @PostMapping("/{userid}/update")
    public String update(@PathVariable long userid,
                         Model model, @Validated @ModelAttribute("user") User user,
                         @RequestParam("roleId") long roleId, BindingResult result) {
        User oldUser = userService.readById(userid);
        if (result.hasErrors()) {
            user.setRole(oldUser.getRole());
            model.addAttribute("roles", roleService.getAll());
            return "update";
        }
        if (oldUser.getRole().getName().equals("USER")) {
            user.setRole(oldUser.getRole());
        } else {
            user.setRole(roleService.readById(roleId));
        }
        userService.update(user);
        return "redirect:/users/" + userid + "/read";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }
}
