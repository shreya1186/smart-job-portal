package com.smartjobportal.smart_job_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import com.smartjobportal.smart_job_portal.dto.CompanyDashboardResponse;

import com.smartjobportal.smart_job_portal.dto.DashboardResponse;
import com.smartjobportal.smart_job_portal.dto.StudentDashboardResponse;
import com.smartjobportal.smart_job_portal.entity.ApplicationStatus;
import com.smartjobportal.smart_job_portal.entity.Role;
import com.smartjobportal.smart_job_portal.repository.ApplicationRepository;
import com.smartjobportal.smart_job_portal.repository.CompanyRepository;
import com.smartjobportal.smart_job_portal.repository.JobRepository;
import com.smartjobportal.smart_job_portal.repository.UserRepository;

@Service
public class DashboardServiceImpl implements DashboardService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public DashboardResponse getAdminDashboard() {
        long totalUsers = userRepository.count();

        long totalStudents = userRepository.countByRole(Role.STUDENT);

        long totalCompanies = userRepository.countByRole(Role.COMPANY);

        long totalJobs = jobRepository.count();

        long totalApplications = applicationRepository.count();

        return new DashboardResponse(
            totalUsers,
            totalStudents,
            totalCompanies,
            totalJobs,
            totalApplications
        );
    }

    @Override
    public StudentDashboardResponse getStudentDashboard(Long studentId){
        long totalApplication = applicationRepository.countByStudentId(studentId);

        long selectedJobs = applicationRepository.countByStudentIdAndStatus(
            studentId, ApplicationStatus.SELECTED);

        long rejectedJobs = applicationRepository.countByStudentIdAndStatus(
            studentId, ApplicationStatus.REJECTED);
            
        return new StudentDashboardResponse(
            totalApplication,
            selectedJobs,
            rejectedJobs    
        );    
    }

    @Override
    public CompanyDashboardResponse getCompanyDashboard(Long companyId){

        long jobsPosted = jobRepository.countByCompanyId(companyId);

        long applicationReceived = applicationRepository.countByJobCompanyId(companyId);

        long openJobs = jobRepository.countByCompanyIdAndDeadlineGreaterThanEqual(companyId, LocalDate.now());

        return new CompanyDashboardResponse(
            jobsPosted,
            applicationReceived,
            openJobs
        );
    }
}
