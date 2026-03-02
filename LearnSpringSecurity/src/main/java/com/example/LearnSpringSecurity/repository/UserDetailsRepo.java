package com.example.LearnSpringSecurity.repository;

import com.example.LearnSpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {
    public Users findByUsername(String username);
}
