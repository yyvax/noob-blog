package com.nooblog.controller;

import com.nooblog.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

public class RegisterController {
    @GetMapping("/signup")
    public String showSignUpForm(WebRequest request, Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "signup";
    }
}
