package com.smartjobportal.smart_job_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {
    
    private long totalUser;

    private long totalStudents;

    private long totalCompanies;

    private long totalJobs;

    private long totalApplication;
}
