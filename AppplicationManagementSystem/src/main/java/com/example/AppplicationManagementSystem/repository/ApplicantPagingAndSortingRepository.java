package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant, Integer> {
}
