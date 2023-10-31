package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.StudentDTO;
import com.example.springbootdemo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/rest/api/students")
public class StudentsController {


    private StudentsService studentsService;
    @Autowired
    public void setStudentsService(StudentsService studentsService){
        this.studentsService = studentsService;
    }
    @PostMapping("/add")
    public ResponseEntity <StudentDTO> saveStuden(@RequestBody StudentDTO studentDTO){
        StudentDTO result = studentsService.createStudent(studentDTO);
        return ResponseEntity.ok().body(result);
    }
}
