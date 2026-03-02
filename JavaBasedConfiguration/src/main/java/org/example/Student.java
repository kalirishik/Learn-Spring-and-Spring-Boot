package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int rollno;

    @Autowired
    private Writer writer;

    @Autowired
    public Student(Writer writer) {
        System.out.println("Constructor Autowired");
        this.writer = writer;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public Writer getWriter() {
        return writer;
    }

    @Autowired
    public void setWriter(Writer writer) {
        System.out.println("setter Autowired");
        this.writer = writer;
    }

    public Student(){
        System.out.println("Student class is created");
    }
    public void show(){
        System.out.println("Show Method");
    }

    public void writeExam(){
        writer.write();
    }
}
