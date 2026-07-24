package com.smartjobportal.smart_job_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportal.smart_job_portal.dto.JobRequest;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.service.JobService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/job")
@Validated
public class JobController {
    
    @Autowired
    private JobService jobService;

    @PostMapping("/{companyId}")
    public JobResponse createJob(@PathVariable Long companyId,
                                 @Valid @RequestBody JobRequest request){
        return jobService.createJob(companyId, request);                            
    }

    @GetMapping("/{jobId}")
    public JobResponse getJob(@PathVariable Long jobId){
        return jobService.getJobById(jobId);
    }

    @GetMapping("/jobs")
    public List<JobResponse> getAllJobs(){
        return jobService.getAllJobs();
    }
    
    @PutMapping("/{jobId}")
    public JobResponse updateJob(@PathVariable Long jobId,@RequestBody @Valid JobRequest request){
        return jobService.updateJob(jobId, request);
    }

    @DeleteMapping("/{jobId}")
    public String deleteJob(@PathVariable Long jobId){
        jobService.deleteJob(jobId);
        return "Job Deleted Successfully";
    }
}
