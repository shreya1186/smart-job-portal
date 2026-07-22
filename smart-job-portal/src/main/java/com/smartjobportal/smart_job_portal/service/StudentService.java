package com.smartjobportal.smart_job_portal.service;

import com.smartjobportal.smart_job_portal.dto.StudentProfileRequest;
import com.smartjobportal.smart_job_portal.dto.StudentProfileResponse;

public interface StudentService {
    
    StudentProfileResponse createOrUpdateProfile(Long userId, StudentProfileRequest request);

    StudentProfileResponse getProfile(Long userId);

    void deleteProfile(Long userId);
}
