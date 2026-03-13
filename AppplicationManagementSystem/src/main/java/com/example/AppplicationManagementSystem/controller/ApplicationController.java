package com.example.AppplicationManagementSystem.controller;

import com.example.AppplicationManagementSystem.model.Application;
import com.example.AppplicationManagementSystem.model.Resume;
import com.example.AppplicationManagementSystem.service.ApplicantService;
import com.example.AppplicationManagementSystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/addApplication/{id}")
    public Application addApplication(@PathVariable Long id, @RequestBody Application application) {
        return applicationService.addApplication(id,application);
    }

    @GetMapping("/getAllApplications")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }
}
