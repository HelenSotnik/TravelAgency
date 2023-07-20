package com.softserve.controller;

import com.softserve.model.User;
import com.softserve.service.RoleService;
import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('MANAGER') or isAnonymous()")
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PreAuthorize("hasAuthority('MANAGER') or isAnonymous()")
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        user.setPassword(user.getPassword());
        user.setRole(roleService.getByRoleName("USER"));
        userService.create(user);
        return "redirect:/";
    }

    @PostAuthorize("hasAuthority('MANAGER') or hasAuthority('USER') and #id== authentication.id")
    @GetMapping("/{id}/read")
    public String read(@PathVariable long id, Model model) throws EntityNotFoundException {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER') and #id== authentication.id")
    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAll());
        return "edit";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER') and #id== authentication.id")
    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, Model model,
                         @Validated @ModelAttribute("user") User user, BindingResult result) {
        User oldUser = userService.readById(id);
        if (result.hasErrors()) {
            user.setRole(oldUser.getRole());
            return "edit";
        }
        user.setRole(oldUser.getRole());
        userService.update(user);
        return "redirect:/agency-manager";
    }

    @PreAuthorize("hasAuthority('MANAGER') or hasAuthority('USER') and #id== authentication.id")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) throws EntityNotFoundException {
        userService.delete(id);
        return "redirect:/agency-manager";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }
}
