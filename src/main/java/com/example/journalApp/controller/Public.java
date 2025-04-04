package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public")
@RestController
class Public {
    @Autowired
    private UserService UserService;

    @GetMapping("/health")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        UserService.saveNewUser(user);
    }
}