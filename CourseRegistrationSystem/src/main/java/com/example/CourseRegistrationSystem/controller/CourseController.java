package com.example.CourseRegistrationSystem.controller;

import com.example.CourseRegistrationSystem.model.Course;
import com.example.CourseRegistrationSystem.model.CourseRegistry;
import com.example.CourseRegistrationSystem.service.CourseService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
@CrossOrigin(origins="http://127.0.0.1:5500/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/enrollCourse")
    public String enrollCourse(@RequestParam String name, @RequestParam String emailId,
                               @RequestParam String courseName){
        courseService.enrollCourse(new CourseRegistry(name,emailId,courseName));
        return "Successfully "+courseName+" course enrolled! "+name;
    }
}
