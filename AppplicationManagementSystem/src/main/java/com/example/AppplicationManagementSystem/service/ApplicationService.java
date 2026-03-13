package com.example.AppplicationManagementSystem.service;

import com.example.AppplicationManagementSystem.model.Applicant;
import com.example.AppplicationManagementSystem.model.Application;
import com.example.AppplicationManagementSystem.repository.ApplicantJpaRepository;
import com.example.AppplicationManagementSystem.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application addApplication(Long id, Application application) {
        Applicant applicant=applicantJpaRepository
                .findById(Math.toIntExact(id))
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Applicant Id: " + id + " not found"
                        ));

        application.setApplicant(applicant);
        return applicationRepository.save(application);
    }
}
