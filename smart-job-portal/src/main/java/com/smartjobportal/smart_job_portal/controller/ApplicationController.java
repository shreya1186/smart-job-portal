package com.smartjobportal.smart_job_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;   

import com.smartjobportal.smart_job_portal.dto.ApplicationRequest;
import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.entity.ApplicationStatus;
import com.smartjobportal.smart_job_portal.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ApplicationResponse applyJob(@RequestBody ApplicationRequest request){
        return applicationService.applyJob(request);
    }

    @GetMapping("/{studentId}")
    public List<ApplicationResponse> getApplications(@PathVariable Long studentId){
        return applicationService.getApplications(studentId);
    }

    @PutMapping("/{applicationId}/status")
    public ApplicationResponse updateApplicationStatus(
        @PathVariable Long applicationId,
        @RequestParam ApplicationStatus status){
            return applicationService.updateApplicationStatus(applicationId, status);
    }

    @DeleteMapping("/{applicationId}")
    public void deleteApplication(@PathVariable Long applicationId){
        applicationService.deleteApplication(applicationId);
    }

}
