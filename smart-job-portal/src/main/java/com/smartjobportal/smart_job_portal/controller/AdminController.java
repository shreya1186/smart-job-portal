package com.smartjobportal.smart_job_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.entity.User;
import com.smartjobportal.smart_job_portal.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return adminService.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        adminService.deleteUser(id);
        return "User Deleted successfully";
    }

    @GetMapping("/companies")
    public List<CompanyResponse> getAllCompanies(){
        return adminService.getAllCompanies();
    }

    @DeleteMapping("/company/{id}")
    public String deleteCompany(@PathVariable Long id){
        adminService.deleteCompany(id);
        return "Company deleted Successfully";
    }

    @GetMapping("/jobs")
    public List<JobResponse> getAllJobs(){
        return adminService.getAllJobs();
    }

    @DeleteMapping("/job/{id}")
    public String deleteJob(@PathVariable Long id){
        adminService.deleteJob(id);
        return "Job Deleted Successfully";
    }

    @GetMapping("/applications")
    public List<ApplicationResponse> getAllApplications() {
        return adminService.getAllApplications();
    }
}
