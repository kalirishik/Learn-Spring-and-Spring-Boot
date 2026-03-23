package com.rishi.StudentDocker.service;

import com.rishi.StudentDocker.model.Student;
import com.rishi.StudentDocker.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int rno) {
        Optional<Student> st=studentRepo.findById(rno);
        return st.orElse(null);
    }

    public String addStudent(Student student) {
        studentRepo.save(student);
        return "Student Id: "+student.getRollno()+" data has been added.";
    }

    public String addStudents(List<Student> students) {
        studentRepo.saveAll(students).toString();
        return "Student data has been added.";
    }

    public String updateStudent(Student student) {
        studentRepo.save(student);
        return "Student Id: "+student.getRollno()+" data has been updated.";
    }

    public String deleteStudent(Student student) {
        studentRepo.deleteById(student.getRollno());
        return "Student Id: " + student.getRollno() + " data has been deleted";
    }

    public List<Student> getAllStudentsByTechnology(String technology) {
        List<Student> res=studentRepo.findAllByTechnology(technology);
        return res==null?new ArrayList<Student>():res;
    }

    public List<Student> getAllStudentsByGenderAndTechnology(String gender, String technology) {
        List<Student> res = studentRepo.findAllByGenderAndTechnology(gender,technology);
        return res==null?new ArrayList<Student>():res;
    }

    public Student getStudentByName(String name) {
        Optional<Student> st= Optional.ofNullable(studentRepo.findByName(name));
        return st.orElse(new Student());
    }
}
