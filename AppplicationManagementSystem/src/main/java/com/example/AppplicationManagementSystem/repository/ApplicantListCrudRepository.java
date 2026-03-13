package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Applicant;
import org.springframework.data.repository.ListCrudRepository;

public interface ApplicantListCrudRepository extends ListCrudRepository<Applicant, Integer> {
}
