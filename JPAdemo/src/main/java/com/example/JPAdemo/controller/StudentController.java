package com.example.JPAdemo.controller;

import com.example.JPAdemo.model.Student;
import com.example.JPAdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins= "http://127.0.0.1:5500/")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//    @GetMapping("/getStudentByRollno/{rno}")
//    public Student getStudentById(@PathVariable int rno) {
//        return studentService.getStudentById(rno);
//    }

//    @GetMapping("/getStudentByRollno/{rno}")
//    public ResponseEntity<Student> getStudentById(@PathVariable int rno) {
//        Student st=studentService.getStudentById(rno);
//        if(st == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(st, HttpStatus.OK);
//    }

    @GetMapping("/getStudentByRollno/{rno}")
    public ResponseEntity<?> getStudentById(@PathVariable int rno) {
        Student st=studentService.getStudentById(rno);
        if(st == null)
            return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @GetMapping("/getAllStudentsByTechnology/{tech}")
    public List<Student> getAllStudentsByTechnology(@PathVariable("tech") String technology) {
        return studentService.getAllStudentsByTechnology(technology);
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/addStudentByParam")
    public String addStudentByParam(@RequestParam int rollno,@RequestParam String name,@RequestParam int age,
                                    @RequestParam String gender,@RequestParam String technology) {
        return studentService.addStudent(new Student(rollno,name,age,gender,technology));
    }

    @GetMapping("/getStudentByName")
    public Student getStudentByName(@RequestParam("name") String name) {
        return studentService.getStudentByName(name);
    }
    @PostMapping("/addStudents")
    public String addStudents(@RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }

    @PostMapping("/getAllStudentsByGenderAndTechnology")
    public List<Student> getAllStudentsByGenderAndTechnology(@RequestParam("gender") String gender, @RequestParam("technology") String technology) {
        return studentService.getAllStudentsByGenderAndTechnology(gender,technology);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student);
    }


}
