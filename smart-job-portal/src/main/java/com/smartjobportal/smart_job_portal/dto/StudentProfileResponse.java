package com.smartjobportal.smart_job_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileResponse {
    private Long id;

    private String college;

    private String degree;

    private String branch;

    private String skills;

    private String phone;

    private String github;

    private String linkedin;

    private String address;

    private String about;
}
