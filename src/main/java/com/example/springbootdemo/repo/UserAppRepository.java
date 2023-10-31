package com.example.springbootdemo.repo;

import com.example.springbootdemo.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository  extends JpaRepository<UserApp, Long> {
    UserApp findByEmail(String email);
}
