package com.smartjobportal.smart_job_portal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    
    @Email(message="Enter Valid email")
    @NotBlank(message="Email is required")
    private String email;

    @Size(min=8, message="Password must be atleast 8 characters")
    @NotBlank(message="Password is required")
    private String password;
}
