package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
