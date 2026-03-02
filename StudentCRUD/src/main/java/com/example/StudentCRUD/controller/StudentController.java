package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{rno}")
    public Student getStudent(@PathVariable int rno) {
        return studentService.getStudentById(rno);
    }

    @PostMapping("/student/addStudent")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/student/addStudents")
    public String addStudents(@RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }

    @PutMapping("/student/updateStudent")
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/deleteStudent")
    public String deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student);
    }
}
