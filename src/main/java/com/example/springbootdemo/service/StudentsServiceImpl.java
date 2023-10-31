package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.StudentDTO;
import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.repo.CoursesRepository;
import com.example.springbootdemo.repo.StudentsRepository;
import jakarta.annotation.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Resource
    private StudentsRepository studentsRepository;

    @Resource
    private CoursesRepository coursesRepository;


    @Transactional
    @Override
    public List<StudentDTO> findAllStudents() {
        List<StudentDTO> allDTOs = new ArrayList<>();
        List<Student> all = studentsRepository.findAll();
        all.forEach(student -> {
            StudentDTO dto = convertFromEntityToDTO(student);
            allDTOs.add(dto);
        });
        return allDTOs;
    }

    @Transactional
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        convertFromDTOtoEntity(studentDTO, student);
        Student savedStudent = studentsRepository.save(student);
        StudentDTO justSavedStudentDTO =  convertFromEntityToDTO(savedStudent);
        return justSavedStudentDTO;
    }

    @Transactional
    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentsRepository.findById(id).get();
        student.setCourses(null);
        convertFromDTOtoEntity(studentDTO, student);
        Student st  = studentsRepository.save(student);
        return convertFromEntityToDTO(st);
    }

    @Transactional
    @Override
    public String deleteStudent(Long id) {
        Optional<Student> optional = studentsRepository.findById(id);
        if(optional.isPresent()){
            optional.get().setCourses(null);
            studentsRepository.delete(optional.get());
            return String.format("Student with ID %d is deleted ", id);
        } else
            return String.format("Student with ID %d is not presented", id);
    }

    private void convertFromDTOtoEntity(StudentDTO studentDTO, Student student){
        student.setName(studentDTO.getName());
        student.setLastName(studentDTO.getLastName());
       // if(studentDTO.getCourses() == null || studentDTO.getCourses().isEmpty()){
            student.setCourses(new HashSet<>());
      //  }

        studentDTO.getCourses().stream().forEach( course -> {
            Course c = coursesRepository.findByName(course);
            if(c == null){
                c = new Course();
                c.setHours(0);
                c.setStudents(new HashSet<>());
            }
            c.setName(course);
            student.getCourses().add(c);
        });
    }



    private StudentDTO convertFromEntityToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setId(student.getId());
        studentDTO.setCourses(student.getCourses().stream().map(Course::getName).collect(Collectors.toSet()));
        return studentDTO;
    }
}
