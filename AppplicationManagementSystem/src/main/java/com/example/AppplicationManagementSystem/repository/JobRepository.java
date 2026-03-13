package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
