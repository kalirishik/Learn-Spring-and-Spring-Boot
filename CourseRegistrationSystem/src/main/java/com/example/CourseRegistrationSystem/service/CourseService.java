package com.example.CourseRegistrationSystem.service;

import com.example.CourseRegistrationSystem.model.Course;
import com.example.CourseRegistrationSystem.model.CourseRegistry;
import com.example.CourseRegistrationSystem.repository.CourseRegistryRepo;
import com.example.CourseRegistrationSystem.repository.CourseRepo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseRegistryRepo courseRegistryRepo;

    public List getAllCourses() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> getEnrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(CourseRegistry courseRegistry) {
        courseRegistryRepo.save(courseRegistry);
    }
}
