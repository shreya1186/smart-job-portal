package com.smartjobportal.smart_job_portal.dto;

import java.time.LocalDate;

import com.smartjobportal.smart_job_portal.entity.ApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponse {
    private Long id;

    private String studentName;

    private String jobTitle;

    private ApplicationStatus status;

    private LocalDate appliedDate;

    private String coverLetter;
}
