package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.StudentDTO;

import java.util.List;

public interface StudentsService {

    List<StudentDTO> findAllStudents();
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    String deleteStudent(Long id);
    //..
}
