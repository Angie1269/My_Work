package com.example.portfolio.controllers;

import com.example.portfolio.models.Contact;
import com.example.portfolio.models.User;
import com.example.portfolio.services.ContactService;
import com.example.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;


@Controller
public class ContactController {

    UserService userService;
    ContactService contactService;

    @Autowired
    public ContactController(UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        Contact createContact = new Contact();
        model.addAttribute("contact", createContact);
        model.addAttribute("failed", false);
        return "contact";
    }

    @PostMapping(path = "/contact")
    public String createContact(@RequestParam(name = "name") String name,
                                @RequestParam(name = "message") String message,
                                @ModelAttribute Contact contact,
                                @SessionAttribute(value = "user", required = false) User user, Model model) {
        if (!contact.getName().isEmpty() && !contact.getMessage().isEmpty()) {
            if (Objects.equals(user, new User())) {
                contactService.saveContact(contact);
            } else {
                contactService.saveContact(contact);
                contact.setUser(user);
                contactService.saveContact(contact);
                model.addAttribute("name", name);
                model.addAttribute("message", message);
            }
            return "redirect:/";
        } else {
            model.addAttribute("falied", true);
        }
        return "redirect:/";


    }
}
