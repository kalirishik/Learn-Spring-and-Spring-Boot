package com.example.LearnSpringSecurity.service;

import com.example.LearnSpringSecurity.model.Users;
import com.example.LearnSpringSecurity.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    @Autowired
    UserDetailsRepo userDetailsRepo;

    public String addUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
        return "User Id: "+user.getId()+" data has been added Successfully";
    }

    public List<Users> getUsers() {
        return userDetailsRepo.findAll();
    }
}
