package com.smartjobportal.smart_job_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;   
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/job/{jobId}")
    public List<ApplicationResponse> getApplicationsByJob(@PathVariable Long jobId){
        return applicationService.getApplicationsByJob(jobId);
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
