package com.smartjobportal.smart_job_portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartjobportal.smart_job_portal.entity.StudentProfile;
import com.smartjobportal.smart_job_portal.entity.User;


public interface StudentRepository extends JpaRepository<StudentProfile,Long> {
    
    Optional<StudentProfile> findByUser(User user);
}
