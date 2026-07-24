package com.smartjobportal.smart_job_portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjobportal.smart_job_portal.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
    List<Job> findByCompanyId(Long companyId);
}
