package com.example.LearnSpringSecurity.controller;

import com.example.LearnSpringSecurity.model.Users;
import com.example.LearnSpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }
    @GetMapping("/getAllUsers")
    public List<Users> getUsers() {
        return userService.getUsers();
    }
}
