package com.smartjobportal.smart_job_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDashboardResponse {
    private long totalApplication;

    private long selectedJobs;

    private long rejectedJobs;
}
