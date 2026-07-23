package com.smartjobportal.smart_job_portal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {
    
    @NotBlank(message="company name is required.")
    private String companyName;

    private String website;

    private String location;

    private String description;
}
