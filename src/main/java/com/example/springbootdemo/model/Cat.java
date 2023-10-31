package com.example.springbootdemo.model;

import com.example.springbootdemo.old.Test123;
import lombok.*;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Cat {
    private int id;
    private String name;
    private int age;

    public Cat(int id){
        this.id = id;
    }


    public String toString2() {
        return "ID = " + id;
    }
}
