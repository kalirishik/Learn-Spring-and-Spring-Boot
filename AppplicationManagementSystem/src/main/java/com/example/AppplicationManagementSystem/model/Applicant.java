package com.example.AppplicationManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private String status;

    @OneToOne(mappedBy = "applicant",cascade = CascadeType.ALL)
    private Resume resume;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Application> applications =  new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="applicant_jobs",
            joinColumns = @JoinColumn(name="applicantId"),
            inverseJoinColumns = @JoinColumn(name="jobId")
    )
    private List<Job> jobs =  new ArrayList<>();
}
