package com.smartjobportal.smart_job_portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportal.smart_job_portal.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
    List<Application> findByStudentId(Long studentId);

    Optional<Application> findByStudentIdAndJobId(Long studentId, Long jobId);
}
