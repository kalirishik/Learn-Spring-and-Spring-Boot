package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Applicant;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantListPagingAndSortingRepository extends ListPagingAndSortingRepository<Applicant, Integer> {
}
