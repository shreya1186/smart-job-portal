package com.smartjobportal.smart_job_portal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="company")
public class Company {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String companyName;

    private String website;

    private String location;

    @Column(columnDefinition="TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
