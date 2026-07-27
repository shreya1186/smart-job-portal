package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.entity.User;

public interface AdminService {
    List<User> getAllUsers();
    
    void deleteUser(Long userId);

    List<CompanyResponse> getAllCompanies();

    void deleteCompany(Long companyId);
    
    List<JobResponse> getAllJobs();

    void deleteJob(Long jobId);

    List<ApplicationResponse> getAllApplications();
}
