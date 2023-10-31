package com.example.springbootdemo.repo;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Integer> {
    List<Course> findAll();
    Course findByName(String name);
}
