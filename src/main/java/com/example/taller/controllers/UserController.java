package com.example.taller.controllers;

import com.example.taller.models.User;
import com.example.taller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute User user) {
        try {
            this.service.save(user);
            return new RedirectView("/login");
        } catch (Exception ex) {
            return new RedirectView("/register?Duplicate");
        }
    }


}