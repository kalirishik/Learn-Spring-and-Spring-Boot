package com.example.StudentCRUD.service;

import com.example.StudentCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    List<Student> students=new ArrayList<>(
      Arrays.asList(new Student(102,"naresh","Excel"),
              new Student(103,"mani","Java"),
              new Student(104,"kali rishi k","Spring Boot")
      )
    );

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id){
        for(Student s:students){
            if(s.getRollno()==id){
                return s;
            }
        }
        return null;
    }

    public String addStudent(Student student) {
        students.add(student);
        return "Student added successfully";
    }
    public String addStudents(List<Student> studentlist) {
        students.addAll(studentlist);
        return "Students list added successfully";
    }

    public String updateStudent(Student student) {
        
        for (Student s : students) {
            if (s.getRollno() == student.getRollno()) {
                s.setName(student.getName());
                s.setTechnology(student.getTechnology());
                return "Student updated successfully";
            }
        }
        return "Student not found";
    }

    public String deleteStudent(Student student) {

        for(int i=0;i<students.size();i++){
            if(students.get(i).getRollno()==student.getRollno()){
                students.remove(i);
                return "Student deleted successfully";
            }
        }
        return "Student not found";
    }
}

