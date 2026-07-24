package com.smartjobportal.smart_job_portal.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    private Double salary;

    private String location;

    private String experience;

    private String skills;

    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
}
