package com.example.portfolio.services;

import com.example.portfolio.models.User;
import com.example.portfolio.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositorie userRepositorie;

    @Autowired
    public UserServiceImpl(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }


    @Override
    public void saveUser(User user) {
        userRepositorie.save(user);
    }

    @Override
    public boolean validateUser(String username, String password) {
        return userRepositorie.getUserByUsernameAndPassword(username, password) != null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepositorie.getUserByUsername(username);
    }


}

