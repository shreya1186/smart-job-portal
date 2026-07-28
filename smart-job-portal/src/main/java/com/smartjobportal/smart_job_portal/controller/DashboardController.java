package com.smartjobportal.smart_job_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportal.smart_job_portal.dto.DashboardResponse;
import com.smartjobportal.smart_job_portal.dto.StudentDashboardResponse;
import com.smartjobportal.smart_job_portal.dto.CompanyDashboardResponse;
import com.smartjobportal.smart_job_portal.service.DashboardService;

@RestController
public class DashboardController {
    
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/admin/dashboard")
    public DashboardResponse getAdminDashboard(){
        return dashboardService.getAdminDashboard();
    }

    @GetMapping("/student/dashboard/{studentId}")
    public StudentDashboardResponse getStudentDashboard(@PathVariable Long studentId){
        return dashboardService.getStudentDashboard(studentId);
    }

    @GetMapping("/company/dashboard/{companyId}")
    public CompanyDashboardResponse getCompanyDashboard(@PathVariable Long companyId){
        return dashboardService.getCompanyDashboard(companyId);
    }
}
