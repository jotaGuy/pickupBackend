package com.friends.backend.controller;

import com.friends.backend.dto.UserForm;
import com.friends.backend.service.serviceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
//        model.addAttribute("userForm", new UserForm());
//        System.out.println("Registered");
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserForm userForm,
                               BindingResult bindingResult) {

        System.out.println("creating");

        System.out.println("form: " + userForm.getUsername());

        if (bindingResult.hasErrors()) {
            System.out.println("Erros:" + bindingResult.getAllErrors());
            return "register";
        }

        // Convert UserForm to User entity and save
        userService.createUser(userForm);

        return "redirect:/login"; // Redirect to login page
    }

    @GetMapping("/profile/{userId}")
    public String showProfileForm(@PathVariable Long userId, Model model) {
        // Fetch user data by userId and populate the model
        UserForm userForm = userService.getUserById(userId);
        model.addAttribute("userForm", userForm);
        return "profile";
    }

    @PostMapping("/profile/{userId}")
    public String updateProfile(@PathVariable Long userId, @Valid @ModelAttribute("userForm") UserForm userForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile";
        }

        // Update user profile
        userService.updateUser(userId, userForm);

        return "redirect:/profile/{userId}"; // Redirect to profile page
    }
}

