package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
