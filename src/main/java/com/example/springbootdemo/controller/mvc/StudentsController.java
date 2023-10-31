package com.example.springbootdemo.controller.mvc;

import com.example.springbootdemo.dto.StudentDTO;
import com.example.springbootdemo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mvc/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/all")
    public String showAllStudents(Model model){
        List<StudentDTO> studentDTOList = studentsService.findAllStudents();
        model.addAttribute("students", studentDTOList);
        return "students-home";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("student", new StudentDTO());

        return "students-adding";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("student") StudentDTO student){
        studentsService.createStudent(student);
        return "redirect:/mvc/students/all";
    }

}
