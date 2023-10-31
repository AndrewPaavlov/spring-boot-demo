package com.example.springbootdemo.dto;

import com.example.springbootdemo.model.Course;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String lastName;
    private Set<String> courses = new HashSet<String>();
}

