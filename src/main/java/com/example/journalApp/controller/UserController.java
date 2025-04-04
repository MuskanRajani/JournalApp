package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserRepository;
import com.example.journalApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @Autowired
    public UserRepository UserRepository;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        //geeting username and password through authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User UserInDB =UserService.findByUsername(username);
           UserInDB.setUserName(user.getUserName());
            UserInDB.setPassword(user.getPassword());
            UserService.saveNewUser(UserInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        //geeting username and password through authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

