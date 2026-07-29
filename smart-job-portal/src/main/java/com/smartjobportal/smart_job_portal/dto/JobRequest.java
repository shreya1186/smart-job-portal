package com.smartjobportal.smart_job_portal.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    
    @NotBlank(message="title is required")
    private String title;

    @NotBlank(message="description is required")
    private String description;

    @Positive(message = "Salary must be greater than 0")
    @NotNull(message = "Salary is required")
    private Double salary;

    @NotBlank(message="location is required")
    private String location;

    @NotBlank(message="experience is required")
    private String experience;

    @NotBlank(message="skills is required")
    private String skills;

    @FutureOrPresent(message = "Deadline must be today or a future date")
    @NotNull(message = "Deadline is required")
    private LocalDate deadline;
}
