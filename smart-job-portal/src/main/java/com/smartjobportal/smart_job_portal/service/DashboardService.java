package com.smartjobportal.smart_job_portal.service;

import com.smartjobportal.smart_job_portal.dto.CompanyDashboardResponse;
import com.smartjobportal.smart_job_portal.dto.DashboardResponse;
import com.smartjobportal.smart_job_portal.dto.StudentDashboardResponse;

public interface DashboardService {
    DashboardResponse getAdminDashboard();

    StudentDashboardResponse getStudentDashboard(Long studentId);

    CompanyDashboardResponse getCompanyDashboard(Long companyId);
}
