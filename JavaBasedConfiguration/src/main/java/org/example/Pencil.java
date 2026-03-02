package org.example;

import org.springframework.stereotype.Component;

@Component
public class Pencil implements Writer{
    public Pencil(){
        System.out.println("Pencil Class is created");
    }
    public void write(){
        System.out.println("Writing Exam using Pencil");
    }
}
