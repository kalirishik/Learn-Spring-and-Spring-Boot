package com.example.CourseRegistrationSystem.controller;


import com.example.CourseRegistrationSystem.model.CourseRegistry;
import com.example.CourseRegistrationSystem.model.Users;
import com.example.CourseRegistrationSystem.service.CourseService;
import com.example.CourseRegistrationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @GetMapping("/getEnrolledStudents")
    public List<CourseRegistry> getEnrolledStudents(){
        return courseService.getEnrolledStudents();
    }
    @PostMapping("/addUser")
    public String addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        return userService.getUsers();
    }
}
