package com.smartjobportal.smart_job_portal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjobportal.smart_job_portal.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
    List<Job> findByCompanyId(Long companyId);

    List<Job> findByTitleContainingIgnoreCase(String title);

    List<Job> findByLocationContainingIgnoreCase(String location);

    List<Job> findByExperienceContainingIgnoreCase(String experience);

    List<Job> findBySkillsContainingIgnoreCase(String skills);

    Page<Job> findAll(Pageable pageable);


    long countByCompanyId(Long companyId);

    long countByCompanyIdAndDeadlineGreaterThanEqual(Long companyId, LocalDate date);
}
