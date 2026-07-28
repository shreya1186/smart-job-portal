package com.smartjobportal.smart_job_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDashboardResponse {
    private long jobsPosted;

    private long applicationsReceived;

    private long openJobs;
}
