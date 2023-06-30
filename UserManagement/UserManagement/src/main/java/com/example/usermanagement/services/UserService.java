package com.example.usermanagement.services;

import com.example.usermanagement.entities.User;

public interface UserService {

    User registerUser(User user);

    User loginUser(String usernameOrEmail, String password);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    User getUser(Long userId);
}
