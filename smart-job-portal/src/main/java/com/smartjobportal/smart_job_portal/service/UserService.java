package com.smartjobportal.smart_job_portal.service;

import com.smartjobportal.smart_job_portal.dto.AuthResponse;
import com.smartjobportal.smart_job_portal.dto.LoginRequest;
import com.smartjobportal.smart_job_portal.dto.RegisterRequest;

public interface UserService {
    String register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
