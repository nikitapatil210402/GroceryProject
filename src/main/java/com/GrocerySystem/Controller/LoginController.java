package com.GrocerySystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GrocerySystem.entity.User;
import com.GrocerySystem.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Ensure this matches the template name without .html
    }

    @GetMapping("/signup")
    public String showSignUp(Model model) {
        model.addAttribute("user", new User());
        return "SignUp";
    }

    @PostMapping("/do_register")
    public String registerUser(@RequestParam("newUsername") String username,
                               @RequestParam("newPassword") String password,
                               RedirectAttributes redirectAttributes) {
        // Check if the username is already taken
        if (userRepository.existsByEmail(username)) {
            redirectAttributes.addFlashAttribute("error", "Username already exists. Please choose a different one.");
            return "redirect:/signup";
        }

        // Create a new User object
        User user = new User();
        user.setEmail(username);
        user.setPassword(password); // You should hash passwords before saving!

        // Save the user to the database
        userRepository.save(user);

        redirectAttributes.addFlashAttribute("success", "Registration successful! You can now login.");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            RedirectAttributes redirectAttributes) {
        // Retrieve the user by username
        User user = userRepository.findByEmail(username);

        if (user == null || !user.getPassword().equals(password)) {
            // Invalid credentials
            redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
            return "redirect:/login";
        }

        // Valid credentials
        redirectAttributes.addFlashAttribute("success", "Login successful!");
        return "redirect:/home"; // Replace with the actual home page mapping
    }
}
