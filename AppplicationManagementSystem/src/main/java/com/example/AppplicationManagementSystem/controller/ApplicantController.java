package com.example.AppplicationManagementSystem.controller;

import com.example.AppplicationManagementSystem.model.Applicant;
import com.example.AppplicationManagementSystem.model.Resume;
import com.example.AppplicationManagementSystem.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/getAllApplicants-jpa")
    public List<Applicant> getAllApplicantsJpa() {
        return applicantService.getAllApplicantsJpa();
    }

    @GetMapping("/getAllApplicants-crud")
    public List<Applicant> getAllApplicantsCrud() {
        return applicantService.getAllApplicantsCrud();
    }

    @GetMapping("/getApplicantByIdCrud/{id}")
    public Applicant getApplicantByIdCrud(@PathVariable int id) {
        return applicantService.getApplicantByIdCrud(id);
    }

    @GetMapping("/getAllApplicants2")
    public Page<Applicant> getAllApplicants2(@RequestParam int page, @RequestParam int size) {
        return applicantService.getAllApplicants2(page,size);
    }

    @GetMapping("/getAllApplicants1")
    public List<Applicant> getAllApplicants1(@RequestParam int page, @RequestParam int size) {
        return applicantService.getAllApplicants1(page,size);
    }
    @GetMapping("/getApplicantsByPartialName")
    public List<Applicant> getApplicantsByPartialName(@RequestParam String name) {
        return applicantService.getApplicantsByPartialName(name);
    }
    @GetMapping("/getApplicantsByStatus")
    public List<Applicant> getApplicantsByStatus(@RequestParam String status) {
        return applicantService.getApplicantsByStatus(status);
    }

    @PostMapping("/addApplicants")
    public Applicant addApplicant(@RequestBody Applicant applicant) {
        return applicantService.addApplicant(applicant);
    }

    @PutMapping("/updateApplicantById/{id}")
    public Applicant updateApplicantById(@PathVariable int id, @RequestBody Applicant applicant) {
        return applicantService.updateApplicantById(id,applicant);
    }

    @PutMapping("/updateApplicant")
    public Applicant updateApplicant(@RequestBody Applicant applicant) {
        return applicantService.updateApplicant(applicant);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        return applicantService.deleteById(id);
    }
}
