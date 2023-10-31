package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.StudentDTO;
import com.example.springbootdemo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/rest/api/students")
public class StudentsControllerRest {


    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO result = studentsService.createStudent(studentDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> findAll(){
        List<StudentDTO> all = studentsService.findAllStudents();
        return ResponseEntity.ok().body(all);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Long id){
        String result = studentsService.deleteStudent(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable(name = "id") Long id,
                                                    @RequestBody StudentDTO studentDTO){
        StudentDTO dto = studentsService.updateStudent(id, studentDTO);
        return ResponseEntity.ok().body(dto);
    }

}
