package com.example.AppplicationManagementSystem.controller;

import com.example.AppplicationManagementSystem.model.Applicant;
import com.example.AppplicationManagementSystem.model.Job;
import com.example.AppplicationManagementSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/addJob")
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @GetMapping("/addJob-to-applicant")
    public Applicant addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId) {
        return jobService.addJobToApplicant(applicantId,jobId);
    }
}
