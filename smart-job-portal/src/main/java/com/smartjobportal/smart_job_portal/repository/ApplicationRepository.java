package com.smartjobportal.smart_job_portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportal.smart_job_portal.entity.Application;
import com.smartjobportal.smart_job_portal.entity.ApplicationStatus;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
    List<Application> findByStudentId(Long studentId);

    Optional<Application> findByStudentIdAndJobId(Long studentId, Long jobId);

    long countByStudentId(long studentId);

    long countByStudentIdAndStatus(Long studentId, ApplicationStatus status);

    // count applications received for all jobs posted by a company.
    long countByJobCompanyId(Long companyId);
}
