package com.example.CourseRegistrationSystem.repository;

import com.example.CourseRegistrationSystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {
    public Users findByUsername(String username);
}
