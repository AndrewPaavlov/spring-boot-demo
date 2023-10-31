package com.example.springbootdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", unique = true , nullable = false)
    private String lastName;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="Students_Courses",
            joinColumns=
            @JoinColumn(name="Student_ID", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="Course_ID", referencedColumnName="ID")
    )
    private Set<Course> courses;

}
