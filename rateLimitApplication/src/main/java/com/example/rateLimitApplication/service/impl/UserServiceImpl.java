package com.example.rateLimitApplication.service.impl;

import com.example.rateLimitApplication.entity.User;
import com.example.rateLimitApplication.repository.UserRepository;
import com.example.rateLimitApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(Long userId) {
        return userRepository.findAll();
    }
}
