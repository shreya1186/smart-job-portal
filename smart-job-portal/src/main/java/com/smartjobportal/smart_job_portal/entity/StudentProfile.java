package com.smartjobportal.smart_job_portal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String college;

    private String degree;

    private String branch;

    private String skills;

    private String phone;

    private String github;

    private String linkedin;

    private String address;

    @Column(length=1000)
    private String about;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
