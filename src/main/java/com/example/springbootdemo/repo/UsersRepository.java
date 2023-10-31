package com.example.springbootdemo.repo;

import com.example.springbootdemo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository <User,Integer> {

    List<User>findAll();
}
