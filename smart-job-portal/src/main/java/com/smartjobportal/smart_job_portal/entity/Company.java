package com.smartjobportal.smart_job_portal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy="company",cascade=CascadeType.ALL)
    private java.util.List<Job>jobs;
}

