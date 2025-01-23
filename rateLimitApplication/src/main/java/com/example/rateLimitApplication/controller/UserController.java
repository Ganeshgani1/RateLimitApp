package com.example.rateLimitApplication.controller;

import com.example.rateLimitApplication.config.RateLimitConfiguration;
import com.example.rateLimitApplication.entity.User;
import com.example.rateLimitApplication.repository.UserRepository;
import com.example.rateLimitApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RateLimitConfiguration rateLimitConfiguration;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/add/user")
    public User registerUser(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/getUsers")
    public List<User> getUsers(@RequestParam Long userId) throws Exception {
       Optional<User> user=userRepository.findById(userId);
        rateLimitConfiguration.allowTransaction(user);
        return userService.getAllUsers(userId);
    }
}
