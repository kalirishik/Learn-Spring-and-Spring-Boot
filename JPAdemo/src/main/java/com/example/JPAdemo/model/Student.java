package com.example.JPAdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private int rollno;
    private String name;
    private int age;
    private String gender;
    private String technology;
}
