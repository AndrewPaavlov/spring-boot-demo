package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.UserRegistrationDTO;
import com.example.springbootdemo.service.UserAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserAppService userService;

    public UserRegistrationController(UserAppService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
