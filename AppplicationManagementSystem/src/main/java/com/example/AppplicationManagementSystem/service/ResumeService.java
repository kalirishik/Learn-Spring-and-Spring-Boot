package com.example.AppplicationManagementSystem.service;

import com.example.AppplicationManagementSystem.model.Applicant;
import com.example.AppplicationManagementSystem.model.Resume;
import com.example.AppplicationManagementSystem.repository.ApplicantJpaRepository;
import com.example.AppplicationManagementSystem.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Resume addResume(Long id, Resume resume) {
//        Optional<Applicant> applicantOptional=applicantJpaRepository.findById(Math.toIntExact(id));
//        if(applicantOptional.isPresent()) {
//            Applicant applicant = applicantOptional.get();
//            resume.setApplicant(applicant);
//            return resumeRepository.save(resume);
//        }
//        else
//            throw new RuntimeException("Applicant Id: "+id+" not found");
        Applicant applicant = applicantJpaRepository
                .findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Applicant Id: " + id + " not found"
                ));

        resume.setApplicant(applicant);
        return resumeRepository.save(resume);
    }
}
