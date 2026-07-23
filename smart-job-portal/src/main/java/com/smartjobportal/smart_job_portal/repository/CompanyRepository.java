package com.smartjobportal.smart_job_portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportal.smart_job_portal.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    Optional<Company> findByUserId(Long userId);
}
