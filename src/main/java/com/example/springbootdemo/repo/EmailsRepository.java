package com.example.springbootdemo.repo;

import com.example.springbootdemo.model.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailsRepository extends CrudRepository<Email,Long> {

        List<Email> findAll();
}
