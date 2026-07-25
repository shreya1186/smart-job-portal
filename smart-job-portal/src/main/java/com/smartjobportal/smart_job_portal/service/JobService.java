package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.smartjobportal.smart_job_portal.dto.JobRequest;
import com.smartjobportal.smart_job_portal.dto.JobResponse;

public interface JobService {

    JobResponse createJob(Long companyId, JobRequest request);

    JobResponse getJobById(Long jobId);

    List<JobResponse> getAllJobs();

    JobResponse updateJob(Long jobId, JobRequest request);

    void deleteJob(Long jobId);

    
    List<JobResponse> searchByTitle(String title);

    List<JobResponse> searchByLocation(String location);

    Page<JobResponse> getJobsWithPagination(int page, int size);

    List<JobResponse> getJobsSortedBySalary();

    List<JobResponse> searchByExperience(String experience);

    List<JobResponse> searchBySkills(String skills);
}

