package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pen implements Writer{
    public Pen(){
        System.out.println("Pen Class is created");
    }
    public void write(){
        System.out.println("Writing Exam using Pen");
    }
}
