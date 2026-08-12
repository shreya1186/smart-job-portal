package com.smartjobportal.smart_job_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.entity.Application;
import com.smartjobportal.smart_job_portal.entity.Company;
import com.smartjobportal.smart_job_portal.entity.Job;
import com.smartjobportal.smart_job_portal.entity.User;
import com.smartjobportal.smart_job_portal.exception.CompanyNotFoundException;
import com.smartjobportal.smart_job_portal.exception.JobNotFoundException;
import com.smartjobportal.smart_job_portal.exception.UserNotFoundException;
import com.smartjobportal.smart_job_portal.repository.ApplicationRepository;
import com.smartjobportal.smart_job_portal.repository.CompanyRepository;
import com.smartjobportal.smart_job_portal.repository.JobRepository;
import com.smartjobportal.smart_job_portal.repository.StudentRepository;
import com.smartjobportal.smart_job_portal.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

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
            .orElseThrow(()->new UserNotFoundException("User not found"));

        studentRepository.findByUser(user)
            .ifPresent(student -> {

            applicationRepository
                    .findByStudentId(student.getId())
                    .forEach(applicationRepository::delete);

            studentRepository.delete(student);

        });

        companyRepository.findByUserId(user.getId())
            .ifPresent(company -> {
                System.out.println("Company Found: " + company.getId());

                List<Job> jobs = jobRepository.findByCompanyId(company.getId());

                System.out.println("Total Jobs: " + jobs.size());

                for(Job job : jobs) {
                    applicationRepository.findByJobId(job.getId())
                        .forEach(applicationRepository::delete);

                    jobRepository.delete(job);    
                }
                companyRepository.delete(company);
                System.out.println("Company Deleted");
            });
            
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
    public void deleteCompany(Long companyId) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() ->
                        new CompanyNotFoundException("Company not found"));

        List<Job> jobs = jobRepository.findByCompanyId(companyId);

        for (Job job : jobs) {

            List<Application> applications =
                    applicationRepository.findByJobId(job.getId());

            for (Application application : applications) {

                applicationRepository.delete(application);

            }

            jobRepository.delete(job);

        }

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
    public void deleteJob(Long jobId) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() ->
                        new JobNotFoundException("Job not found"));

        List<Application> applications = applicationRepository.findByJobId(jobId);

        System.out.println("==================================");
        System.out.println("Job ID = " + jobId);
        System.out.println("Applications Found = " + applications.size());

        for (Application application : applications) {

            System.out.println("Deleting Application ID = " + application.getId());

            applicationRepository.delete(application);

        }

        System.out.println("Deleting Job ID = " + job.getId());

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

    @Override
    public void deleteApplication(Long applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() ->
                        new RuntimeException("Application not found"));

        applicationRepository.delete(application);

    }
}
