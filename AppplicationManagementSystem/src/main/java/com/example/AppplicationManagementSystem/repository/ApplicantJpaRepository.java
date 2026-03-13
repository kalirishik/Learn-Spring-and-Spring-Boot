package com.example.AppplicationManagementSystem.repository;

import com.example.AppplicationManagementSystem.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ApplicantJpaRepository extends JpaRepository<Applicant, Integer> {

    List<Applicant> findByStatus(String status);

    @Query("select u from Applicant u where u.name like %:name%")
    List<Applicant> findByPartialName(@Param("name")String name);

//    @Query(value = "select * from applicant where name like %:name%", nativeQuery = true)
//    List<Applicant> findByPartialName(@Param("name")String name);

}
