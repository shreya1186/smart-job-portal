package com.smartjobportal.smart_job_portal.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    private Long id;

    private String title;

    private String description;

    private Double salary;

    private String location;

    private String experience;

    private String skills;

    private LocalDate deadline;
}
