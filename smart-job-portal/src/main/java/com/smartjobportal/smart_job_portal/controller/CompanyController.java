package com.smartjobportal.smart_job_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportal.smart_job_portal.dto.CompanyRequest;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;
import com.smartjobportal.smart_job_portal.service.CompanyService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @PutMapping("/{userId}")
    public CompanyResponse createOrUpdateCompany(
        @PathVariable Long userId,
        @Valid @RequestBody CompanyRequest request){
            return companyService.createOrUpdateCompany(userId, request);
    }


    @GetMapping("/{userId}")
    public CompanyResponse getCompany(@PathVariable Long userId) {

        return companyService.getCompany(userId);
    }

    @DeleteMapping("{userId}")
    public String deleteCompany(@PathVariable Long userId){
        companyService.deleteCompany(userId);
        return "Company Profile Deleted Successfully";
    }
}
