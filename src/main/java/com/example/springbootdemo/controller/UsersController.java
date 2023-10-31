package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repo.EmailsRepository;
import com.example.springbootdemo.repo.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/users")

public class UsersController {



    private UsersRepository usersRepo;
    private EmailsRepository emailsRepo;

    @Autowired
    public void setUsersRepo(UsersRepository usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Autowired
    public void setEmailsRepo(EmailsRepository emailsRepo) {
        this.emailsRepo = emailsRepo;
    }

    @GetMapping("/status")
    public String isAlive(){
        return "Server time: " + new Date().toString();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") int id){
      Optional<User> optional = usersRepo.findById(id);
      if(optional.isPresent())
          return ResponseEntity.ok().body(optional.get());
      return ResponseEntity.notFound().build();
    }


    @GetMapping()
    public List<User> findAllUsers(){
        List<User> users = usersRepo.findAll();
        System.out.println(users.size());
        return users;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@Validated @RequestBody User user){

        if(Objects.isNull(user.getName()) || Objects.isNull(user.getPersonalNumber()))
            return ResponseEntity.badRequest().body("Required fields is missed");

        System.out.println("Saving...");

        User resultUser = null;
        try {
            resultUser = usersRepo.save(user);

            User u = new User();
            u.setId(user.getId());

            user.getEmails().forEach( email -> {
                //email.setUser(user);
                email.setUser(u);
                emailsRepo.save(email);
            });

            return ResponseEntity.ok().body(resultUser);

        } catch (Exception e){
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping("/test-servlets")
    public void oldStyle(HttpServletRequest req, HttpServletResponse resp){
        String value = req.getParameter("value");
        if(value != null)
            System.out.println(value.toUpperCase());

    }





}
