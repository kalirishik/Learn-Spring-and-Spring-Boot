package org.example;
import lombok.*;

@Data
@Getter
@Setter

public class Student {
    public Student(){
        System.out.println("Student class is created..");
    }

//    private Pen pen;
//
//    public Pen getPen() {
//        return pen;
//    }
//
//    public void setPen(Pen pen) {
//        this.pen = pen;
//    }
//
//    public void writeExam(){
//        pen.write();
//    }

    private int age;
    private int rollno;
    private Writer writer;

    public Student(int age, int rollno, Writer writer) {
        this.age = age;
        this.rollno = rollno;
        this.writer = writer;
        System.out.println("Parameter Called");
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void writeExam(){
        writer.write();
    }

//    public void show(){
//        System.out.println("Student Class");
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        System.out.println("Setter is called by spring");
//        this.age = age;
//    }
//
//    public int getRollno() {
//        return rollno;
//    }
//
//    public void setRollno(int rollno) {
//        System.out.println("Setter is called by spring");
//        this.rollno = rollno;
//    }

}
