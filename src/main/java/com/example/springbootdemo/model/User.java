package com.example.springbootdemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @Column(unique = true)
    @NonNull
    private long personalNumber;

    @OneToMany(mappedBy = "user")
    private List<Email> emails;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(
            name="Users_Roles",
            joinColumns=
            @JoinColumn(name="User_ID", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="Role_ID", referencedColumnName="ID")
    )
    private Set<Role> roles;
}
