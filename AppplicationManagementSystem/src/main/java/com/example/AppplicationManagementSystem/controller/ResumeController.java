package com.example.AppplicationManagementSystem.controller;

import com.example.AppplicationManagementSystem.model.Resume;
import com.example.AppplicationManagementSystem.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/addResume/{id}")
    public Resume addResume(@PathVariable Long id, @RequestBody Resume resume) {
        return resumeService.addResume(id,resume);
    }

    @GetMapping("/getAllResumes")
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }
}
