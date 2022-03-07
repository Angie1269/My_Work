package com.example.portfolio.services;

import com.example.portfolio.models.User;

public interface UserService {
    void saveUser(User user);

    boolean validateUser(String username, String password);

    User getUserByUsername(String username);

}
