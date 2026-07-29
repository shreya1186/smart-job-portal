package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.entity.Company;
import com.smartjobportal.smart_job_portal.entity.Job;
import com.smartjobportal.smart_job_portal.entity.User;
import com.smartjobportal.smart_job_portal.exception.CompanyNotFoundException;
import com.smartjobportal.smart_job_portal.exception.JobNotFoundException;
import com.smartjobportal.smart_job_portal.repository.ApplicationRepository;
import com.smartjobportal.smart_job_portal.repository.CompanyRepository;
import com.smartjobportal.smart_job_portal.repository.JobRepository;
import com.smartjobportal.smart_job_portal.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId){
        User user = userRepository.findById(userId)
            .orElseThrow(()->new JobNotFoundException("Job not found"));

        userRepository.delete(user);
    }

    @Override
    public List<CompanyResponse> getAllCompanies(){
        return companyRepository.findAll()
            .stream()
            .map(company-> new CompanyResponse(
                company.getId(),
                company.getCompanyName(),
                company.getWebsite(),
                company.getLocation(),
                company.getDescription()))
            .toList();
    }

    @Override
    public void deleteCompany(Long companyId){
        Company company = companyRepository.findById(companyId)
            .orElseThrow(()->new CompanyNotFoundException("Company not found"));

        companyRepository.delete(company);    
    }

    @Override
    public List<JobResponse> getAllJobs(){
        return jobRepository.findAll()
            .stream()
            .map(job-> new JobResponse(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getSalary(),
                job.getLocation(),
                job.getExperience(),
                job.getSkills(),
                job.getDeadline()))
            .toList();
    }

    @Override
    public void deleteJob(Long jobId){
        Job job = jobRepository.findById(jobId)
            .orElseThrow(()->new JobNotFoundException("Job not found"));
        jobRepository.delete(job);    
    }
    
    @Override
    public List<ApplicationResponse> getAllApplications() {

        return applicationRepository.findAll()
                .stream()
                .map(application -> new ApplicationResponse(
                        application.getId(),
                        application.getStudent().getUser().getName(),
                        application.getJob().getTitle(),
                        application.getStatus(),
                        application.getAppliedDate(),
                        application.getCoverLetter()))
                .toList();
    }
}
