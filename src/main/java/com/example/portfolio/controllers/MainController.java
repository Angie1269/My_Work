package com.example.portfolio.controllers;

import com.example.portfolio.services.ContactService;
import com.example.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class MainController {

    private final ContactService contactService;
    private final UserService userService;

    @Autowired
    public MainController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }



    @GetMapping(path = "/")
    public String index( Model model) {
        model.addAttribute("contacts", contactService.finAll());
        return "index";
    }
}
