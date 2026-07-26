package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import com.smartjobportal.smart_job_portal.dto.ApplicationRequest;
import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.entity.ApplicationStatus;

public interface ApplicationService {
    
    ApplicationResponse applyJob(ApplicationRequest request);

    List<ApplicationResponse> getApplications(Long studentId);
    
    ApplicationResponse updateApplicationStatus(Long applicationId, ApplicationStatus status);

    void deleteApplication(Long applicationId);
}