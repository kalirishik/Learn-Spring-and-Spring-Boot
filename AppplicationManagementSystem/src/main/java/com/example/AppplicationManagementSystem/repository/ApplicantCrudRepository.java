package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantCrudRepository extends CrudRepository<Applicant, Integer> {
}
