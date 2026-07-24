package com.smartjobportal.smart_job_portal.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    
    @NotBlank(message="title is required")
    private String title;

    @NotBlank(message="description is required")
    private String description;

    @NotNull(message="salary is required")
    private Double salary;

    @NotBlank(message="location is required")
    private String location;

    @NotBlank(message="experience is required")
    private String experience;

    @NotBlank(message="skills is required")
    private String skills;

    @NotNull(message="deadline is required")
    private LocalDate deadline;
}
