package com.example.portfolio.controllers;

import com.example.portfolio.services.ContactService;
import com.example.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    UserService userService;
    ContactService contactService;

    @Autowired
    public ContactController(UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;
    }

   // @GetMapping(path = "/contact")
   // private String ContactView(Model model){
     //   model.addAttribute()
  //  }
}
