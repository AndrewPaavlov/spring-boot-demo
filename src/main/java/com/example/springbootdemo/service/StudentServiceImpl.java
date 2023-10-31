/*package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.StudentDTO;
import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.repo.CoursesRepository;
import com.example.springbootdemo.repo.StudentsRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentsService{

    @Resource
    private StudentsRepository studentsRepository;

    @Resource
    private CoursesRepository coursesRepository;

    @Transactional
    @Override
    public List<StudentDTO> findAllStudents() {
      return null;
    }
    @Transactional
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        convertFromDTO(studentDTO,student);
        Student savedStudent = studentsRepository.save(student);
        StudentDTO justSavedStudentDTO = convertToDTO(savedStudent);
        return justSavedStudentDTO;


    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        return null;
    }

    @Transactional
    @Override
    public StudentDTO updateStudetnt(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    private void convertFromDTO(StudentDTO studentDTO,Student student){
        student.setName(studentDTO.getName());
        student.setLastName(studentDTO.getLastName());
      //  if(studentDTO.getCourses() == null || studentDTO.getCourses().isEmpty()){
            student.setCourses(new HashSet<>());
      //  }
        studentDTO.getCourses().stream().forEach(course ->{
            Course c = coursesRepository.findByName(course);
            if(c == null){
                c= new Course();
                c.setHours(0);
                c.setStudents(new HashSet<>());
            }
            c.setName(course);
            student.getCourses().add(c);
        });
    }


    private  StudentDTO convertToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setId(student.getId());
        studentDTO.setCourses(student.getCourses().stream().map(Course::getName).collect(Collectors.toSet()));
        return studentDTO;
    }
}*/
