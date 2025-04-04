package com.example.journalApp.services;


import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserService {

@Autowired
public UserRepository UserRepository;

//public final static Logger logger= LoggerFactory.getLogger(UserService.class);
public final static PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

public void saveNewUser(User User){
    User.setPassword(passwordEncoder.encode(User.getPassword()));
    User.setRoles(Arrays.asList("User"));
    UserRepository.save(User);
}
    public void saveAdmin(User User){
        User.setPassword(passwordEncoder.encode(User.getPassword()));
        User.setRoles(Arrays.asList("User","ADMIN"));
        log.info("User is added {}",User.getUserName());
        UserRepository.save(User);
    }
public void saveUser(User User){
        UserRepository.save(User);
    }
public List<User> getAll(){
    return UserRepository.findAll();
    }
   public Optional<User> findById(ObjectId id){
    return UserRepository.findById(id);
   }
    public void deleteById(ObjectId id){
        UserRepository.deleteById(id);
    }
    public User findByUsername(String username){
        return UserRepository.findByUsername(username);
    }
}
