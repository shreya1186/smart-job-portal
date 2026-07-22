package com.smartjobportal.smart_job_portal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileRequest {
    
    @NotBlank(message="College is Required")
    private String college;

    @NotBlank(message="Degree is Required")
    private String degree;

    @NotBlank(message="Branch is Required")
    private String branch;

    private String skills;

    private String phone;

    private String github;

    private String linkedin;

    private String address;

    private String about;
}
