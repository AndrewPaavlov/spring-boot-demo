package com.example.springbootdemo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "postal_code")
    private Integer postalCode; // 22021000

    //...
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
