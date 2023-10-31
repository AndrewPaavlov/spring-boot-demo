package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.UserRegistrationDTO;
import com.example.springbootdemo.model.UserApp;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAppService extends UserDetailsService {
    UserApp save(UserRegistrationDTO registrationDto);
}
