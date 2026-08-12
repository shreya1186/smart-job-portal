package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.smartjobportal.smart_job_portal.dto.JobRequest;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.dto.StudentJobResponse;

public interface JobService {

    JobResponse createJob(Long companyId, JobRequest request);

    JobResponse getJobById(Long jobId);

    List<JobResponse> getJobsByCompany(Long companyId);

    List<JobResponse> getAllJobs();

    JobResponse updateJob(Long jobId, JobRequest request);

    void deleteJob(Long jobId);

    List<StudentJobResponse> getAllJobsForStudents();

    
    List<StudentJobResponse> searchByTitle(String title);

    List<StudentJobResponse> searchByLocation(String location);

    Page<StudentJobResponse> getJobsWithPagination(int page, int size);

    List<JobResponse> getJobsSortedBySalary();

    List<StudentJobResponse> searchByExperience(String experience);

    List<StudentJobResponse> searchBySkills(String skills);
}

