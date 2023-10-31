package com.example.springbootdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Emails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void testMeViaReflection(){
        System.out.println("testMeViaReflection");
    }

    public void testMeViaReflection(int times){
        System.out.println("testMeViaReflection with times :" + times);
        while ((times--) > 0){
            testMeViaReflection();
        }
    }
}
