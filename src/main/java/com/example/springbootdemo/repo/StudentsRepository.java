package com.example.springbootdemo.repo;

import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
}
