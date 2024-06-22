package com.example.demo.services;

import com.example.demo.api.model.UserEntity;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServices {
    private final UserRepository userRepository;
    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        UserEntity user = new UserEntity();
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        return userRepository.save(user);
    }
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
    public UserEntity findUserById(Long id){
        return userRepository.findById(id).orElseGet(null);
    }
}
