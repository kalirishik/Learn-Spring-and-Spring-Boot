package com.example.AppplicationManagementSystem.service;

import com.example.AppplicationManagementSystem.model.Applicant;
import com.example.AppplicationManagementSystem.model.Application;
import com.example.AppplicationManagementSystem.model.Resume;
import com.example.AppplicationManagementSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;
    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;
    @Autowired
    private ApplicantListCrudRepository applicantListCrudRepository;
    @Autowired
    private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;
    @Autowired
    private ApplicantListPagingAndSortingRepository applicantListPagingAndSortingRepository;


    public List<Applicant> getAllApplicantsJpa() {
        return applicantJpaRepository.findAll();
    }

    public List<Applicant> getAllApplicantsCrud() {
        return (List)applicantCrudRepository.findAll();
    }

    public Applicant getApplicantByIdCrud(int id) {
        return applicantCrudRepository.findById(id).get();
    }

    public Applicant addApplicant(Applicant applicant) {
        Resume resume=applicant.getResume();
        List<Application> applications=applicant.getApplications();
        if(resume!=null)
            resume.setApplicant(applicant);
        if(applications!=null){
            for(Application app:applications){
                app.setApplicant(applicant);
            }
        }
        return applicantJpaRepository.save(applicant);
    }

    public List<Applicant> getAllApplicants1(int page, int size) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page,size)).getContent();
    }

    public Page<Applicant> getAllApplicants2(int page, int size) {
        return applicantListPagingAndSortingRepository.findAll(PageRequest.of(page,size));
    }

    public Applicant updateApplicantById(int id,Applicant applicant) {
        boolean found = applicantCrudRepository.existsById(id);
        if(found)
            return applicantCrudRepository.save(applicant);
        throw new RuntimeException("Applicant id: "+applicant.getId()+" not found");
    }

    public Applicant updateApplicant(Applicant applicant) {
        boolean found = applicantCrudRepository.existsById(Math.toIntExact(applicant.getId()));
        if(found)
            return applicantCrudRepository.save(applicant);
        throw new RuntimeException("Applicant id: "+applicant.getId()+" not found");
    }

    public String deleteById(int id) {
        boolean found = applicantListCrudRepository.existsById(id);
        if(found){
            applicantListCrudRepository.deleteById(id);
            return "Applicant id: "+id+" has been deleted";
        }
        throw new RuntimeException("Applicant id: "+id+" not found");
    }

    public List<Applicant> getApplicantsByStatus(String status) {
        return applicantJpaRepository.findByStatus(status);
    }

    public List<Applicant> getApplicantsByPartialName(String name) {
        return applicantJpaRepository.findByPartialName(name);
    }

}
