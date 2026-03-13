package com.example.AppplicationManagementSystem.service;

import com.example.AppplicationManagementSystem.model.Applicant;
import com.example.AppplicationManagementSystem.model.Job;
import com.example.AppplicationManagementSystem.repository.ApplicantJpaRepository;
import com.example.AppplicationManagementSystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;


    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public Applicant addJobToApplicant(Long applicantId, Long jobId) {

        Optional<Applicant> applicantOptional=applicantJpaRepository.findById(Math.toIntExact(applicantId));
        Optional<Job> jobOptional=jobRepository.findById(Math.toIntExact(jobId));

        if(applicantOptional.isPresent() && jobOptional.isPresent()) {
            Applicant applicant=applicantOptional.get();
            Job job=jobOptional.get();
            applicant.getJobs().add(job);
            job.getApplicants().add(applicant);
            return applicantJpaRepository.save(applicant);
        }
        throw new RuntimeException("Job not found or Applicant not found");
    }
}
