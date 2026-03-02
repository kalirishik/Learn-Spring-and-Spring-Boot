package com.example.LearnSpringSecurity.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int id;
    private String name;
    private String technolgy;

    public Student() {
    }

    public Student(int id, String name, String technolgy) {
        this.id = id;
        this.name = name;
        this.technolgy = technolgy;
    }

    public String getName() {
        return name;
    }

    public String getTechnolgy() {
        return technolgy;
    }

    public int getId() {
        return id;
    }

}
