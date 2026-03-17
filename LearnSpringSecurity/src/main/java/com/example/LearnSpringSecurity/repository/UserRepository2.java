package com.example.LearnSpringSecurity.repository;

import com.example.LearnSpringSecurity.model.Users2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository2 extends JpaRepository<Users2, Long> {
    Optional<Users2> findByEmailId(String email);
}
