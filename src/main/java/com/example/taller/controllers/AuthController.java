package com.example.taller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String getForAuth() {
        return "auth/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping({"/", "/index"})
    public String inicio() {
        return "index";
    }
}
