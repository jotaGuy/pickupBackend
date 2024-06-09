package com.friends.backend.controller;

import com.friends.backend.dto.UserForm;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@NoArgsConstructor
public class HomeController {

    @Autowired(required = false)
    private UserForm userForm;

    @GetMapping("/")
    public String retrieveAllPost() {
        System.out.println("Retrieving all post");
        return userForm.getUsername();
    }

}
