package com.example.LearnSpringSecurity.controller;

import com.example.LearnSpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> studentList = new ArrayList<>(
            Arrays.asList(
             new Student(101,"kali","java"),
                    new Student(102,"surjith","full stack")
                    )
    );

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentList;
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        studentList.add(student);
        return "Student ID: "+student.getId()+" data has been added";
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
