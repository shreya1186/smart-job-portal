package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import com.smartjobportal.smart_job_portal.dto.JobRequest;
import com.smartjobportal.smart_job_portal.dto.JobResponse;

public interface JobService {
    
    JobResponse createJob(Long companyId, JobRequest request);

    JobResponse getJobById(Long jobId);

    List<JobResponse> getAllJobs();

    JobResponse updateJob(Long jobId, JobRequest request);

    void deleteJob(Long jobId);
}
