package com.smartjobportal.smart_job_portal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.ApplicationRequest;
import com.smartjobportal.smart_job_portal.dto.ApplicationResponse;
import com.smartjobportal.smart_job_portal.entity.Application;
import com.smartjobportal.smart_job_portal.entity.ApplicationStatus;
import com.smartjobportal.smart_job_portal.entity.Job;
import com.smartjobportal.smart_job_portal.entity.StudentProfile;
import com.smartjobportal.smart_job_portal.exception.ApplicationNotFoundException;
import com.smartjobportal.smart_job_portal.exception.JobNotFoundException;
import com.smartjobportal.smart_job_portal.exception.UserNotFoundException;
import com.smartjobportal.smart_job_portal.repository.ApplicationRepository;
import com.smartjobportal.smart_job_portal.repository.JobRepository;
import com.smartjobportal.smart_job_portal.repository.StudentRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobRepository jobRepository;


    @Override
    public ApplicationResponse applyJob(ApplicationRequest request){
        
        StudentProfile student = studentRepository.findById(request.getStudentId())
            .orElseThrow(()->new UserNotFoundException("Student not found"));
           
        Job job = jobRepository.findById(request.getJobId())
            .orElseThrow(()->new JobNotFoundException("Job not found"));
            
        if(applicationRepository.findByStudentIdAndJobId(request.getStudentId(),request.getJobId()).isPresent()){
            throw new RuntimeException("You have already applied for this job");
        }    

        Application application = new Application();

        application.setStudent(student);
        application.setJob(job);
        application.setCoverLetter(request.getCoverLetter());
        application.setAppliedDate(LocalDate.now());
        application.setStatus(ApplicationStatus.APPLIED);

        Application savedApplication = applicationRepository.save(application);

        return mapToResponse(savedApplication);
    }

    @Override
    public List<ApplicationResponse> getApplications(Long studentId){
        
        return applicationRepository.findByStudentId(studentId)
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    @Override
    public ApplicationResponse updateApplicationStatus(Long applicationId, ApplicationStatus status){
        Application application = applicationRepository.findById(applicationId)
            .orElseThrow(()->new ApplicationNotFoundException("Application not found"));

        application.setStatus(status);
        Application savedApplication = applicationRepository.save(application);
        return mapToResponse(savedApplication);    
    }

    @Override
    public void deleteApplication(Long applicationId){
        Application application = applicationRepository.findById(applicationId)
            .orElseThrow(()->new ApplicationNotFoundException("Application not found"));

        applicationRepository.delete(application);
    }

    private ApplicationResponse mapToResponse(Application application){
        return new ApplicationResponse(
            application.getId(),
            application.getStudent().getUser().getName(),
            application.getJob().getTitle(),
            application.getStatus(),
            application.getAppliedDate(),
            application.getCoverLetter()          
        );
    }
}
