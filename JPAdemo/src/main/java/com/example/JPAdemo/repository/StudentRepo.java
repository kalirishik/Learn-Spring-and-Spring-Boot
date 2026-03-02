package com.example.JPAdemo.repository;

import com.example.JPAdemo.model.Student;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

//    Derived Query Method

    List<Student> findAllByTechnology(String technology);

    // user defined custom queries

    // native query - actual sql
    @Query(value= "select * from student where gender= :gender and technology = :technology;",nativeQuery = true)
    List<Student> findAllByGenderAndTechnology(@Param("gender") String gender, @Param("technology") String technology);

    //jpql - Java Persistence Query Language  -  entity class and field

    @Query("select u from Student u where u.name = :name")
    Student findByName(@Param("name") String name);

}
