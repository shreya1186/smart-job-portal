package com.smartjobportal.smart_job_portal.service;

import com.smartjobportal.smart_job_portal.dto.CompanyRequest;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;

public interface CompanyService {
    
    CompanyResponse createOrUpdateCompany(Long userId, CompanyRequest request);

    CompanyResponse getCompany(Long userId);

    void deleteCompany(Long userId);
}
