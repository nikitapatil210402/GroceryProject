package com.GrocerySystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";  // Refers to home.html in templates folder if using Thymeleaf
    }
}
