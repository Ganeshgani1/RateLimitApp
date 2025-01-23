package com.example.rateLimitApplication.service;

import com.example.rateLimitApplication.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAllUsers(Long userId);
}
