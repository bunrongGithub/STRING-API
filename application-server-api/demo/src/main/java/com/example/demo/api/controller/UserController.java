package com.example.demo.api.controller;

import com.example.demo.api.model.UserEntity;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class UserController {
    private final UserServices userServices;
    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }
    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        UserEntity userEntity = userServices.createUser(user);
        return new ResponseEntity<>(userEntity , HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userServices.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity user = userServices.findUserById(id);
        return new ResponseEntity<>(user , HttpStatus.OK);
    }
}
