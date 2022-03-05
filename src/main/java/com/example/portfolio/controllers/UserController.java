package com.example.portfolio.controllers;

import com.example.portfolio.models.User;
import com.example.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupView(Model model) {
        model.addAttribute("user", new User());
        return "/signup";
    }

    @PostMapping(path = "/signup")
    public String Signup(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginView(Model model) {
        return "login";

    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "user") String username,
                        @RequestParam(name = "password") String password, RedirectAttributes redirectAttributes) {
        if (userService.validateUser(username, password)) {
            redirectAttributes.addFlashAttribute("user", userService.getUserByUsername(username));
            return "redirect:/";
        }
        return "index";
    }
}


