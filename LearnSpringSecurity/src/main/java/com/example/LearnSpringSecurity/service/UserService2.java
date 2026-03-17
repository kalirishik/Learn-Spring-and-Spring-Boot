package com.example.LearnSpringSecurity.service;

import com.example.LearnSpringSecurity.model.Users;
import com.example.LearnSpringSecurity.model.Users2;
import com.example.LearnSpringSecurity.repository.UserDetailsRepo;
import com.example.LearnSpringSecurity.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService2 {
    @Autowired
    UserRepository2  userRepository2;

    public String addUser(Users2 user2) {
        userRepository2.save(user2);
        return "User Id: "+user2.getId()+" data has been added Successfully";
    }

    public List<Users2> getUsers() {
        return userRepository2.findAll();
    }
}
