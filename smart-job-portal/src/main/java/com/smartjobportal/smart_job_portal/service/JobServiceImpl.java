package com.smartjobportal.smart_job_portal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.JobRequest;
import com.smartjobportal.smart_job_portal.dto.JobResponse;
import com.smartjobportal.smart_job_portal.entity.Company;
import com.smartjobportal.smart_job_portal.entity.Job;
import com.smartjobportal.smart_job_portal.repository.CompanyRepository;
import com.smartjobportal.smart_job_portal.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
    
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public JobResponse createJob(Long companyId, JobRequest request){
        
        Company company = companyRepository.findById(companyId)
            .orElseThrow(()->new RuntimeException("Company not found"));

        Job job = new Job();
        
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setSalary(request.getSalary());
        job.setLocation(request.getLocation());
        job.setExperience(request.getExperience());
        job.setSkills(request.getSkills());
        job.setDeadline(request.getDeadline());

        job.setCompany(company);

        Job savedJob = jobRepository.save(job);

        return new JobResponse(
                savedJob.getId(),
                savedJob.getTitle(),
                savedJob.getDescription(),
                savedJob.getSalary(),
                savedJob.getLocation(),
                savedJob.getExperience(),
                savedJob.getSkills(),
                savedJob.getDeadline()
        );
    }


    @Override
    public JobResponse getJobById(Long jobId){
        Job job = jobRepository.findById(jobId)
            .orElseThrow(()->new RuntimeException("Job not found"));

        return new JobResponse(
            job.getId(),
            job.getTitle(),
            job.getDescription(),
            job.getSalary(),
            job.getLocation(),
            job.getExperience(),
            job.getSkills(),
            job.getDeadline()
        );    
    }

    @Override
    public List<JobResponse> getAllJobs() {

        List<Job> jobs = jobRepository.findAll();

        return jobs.stream()
                .map(job -> new JobResponse(
                        job.getId(),
                        job.getTitle(),
                        job.getDescription(),
                        job.getSalary(),
                        job.getLocation(),
                        job.getExperience(),
                        job.getSkills(),
                        job.getDeadline()))
                .collect(Collectors.toList());
    }


    @Override
    public JobResponse updateJob(Long jobId, JobRequest request) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setSalary(request.getSalary());
        job.setLocation(request.getLocation());
        job.setExperience(request.getExperience());
        job.setSkills(request.getSkills());
        job.setDeadline(request.getDeadline());

        Job updatedJob = jobRepository.save(job);

        return new JobResponse(
                updatedJob.getId(),
                updatedJob.getTitle(),
                updatedJob.getDescription(),
                updatedJob.getSalary(),
                updatedJob.getLocation(),
                updatedJob.getExperience(),
                updatedJob.getSkills(),
                updatedJob.getDeadline()
        );
    }

    @Override
    public void deleteJob(Long jobId) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        jobRepository.delete(job);
    }



    @Override
    public List<JobResponse> searchByTitle(String title) {

        return jobRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<JobResponse> searchByLocation(String location) {

        return jobRepository.findByLocationContainingIgnoreCase(location)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public Page<JobResponse> getJobsWithPagination(int page, int size) {

        return jobRepository.findAll(PageRequest.of(page, size))
                .map(this::mapToResponse);
    }

    @Override
    public List<JobResponse> getJobsSortedBySalary() {

        return jobRepository.findAll(
                Sort.by(Sort.Direction.ASC, "salary"))
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<JobResponse> searchByExperience(String experience) {
        return jobRepository.findByExperienceContainingIgnoreCase(experience)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<JobResponse> searchBySkills(String skills){
        return jobRepository.findBySkillsContainingIgnoreCase(skills)
                .stream()
                .map(this::mapToResponse)
                .toList();   
    }

    private JobResponse mapToResponse(Job job) {
        return new JobResponse(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getSalary(),
                job.getLocation(),
                job.getExperience(),
                job.getSkills(),
                job.getDeadline()
        );
    }
}
