package com.example.portfolio;

import com.example.portfolio.models.User;
import com.example.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

    UserService userService;

    @Autowired
    public PortfolioApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.saveUser(new User("anonymous", "nothing"));
    }
}
