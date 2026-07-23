package com.smartjobportal.smart_job_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.CompanyRequest;
import com.smartjobportal.smart_job_portal.dto.CompanyResponse;
import com.smartjobportal.smart_job_portal.entity.Company;
import com.smartjobportal.smart_job_portal.entity.User;
import com.smartjobportal.smart_job_portal.repository.CompanyRepository;
import com.smartjobportal.smart_job_portal.repository.UserRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired 
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CompanyResponse createOrUpdateCompany(Long userId, CompanyRequest request){

        User user = userRepository.findById(userId)
            .orElseThrow(()->new RuntimeException("User not found"));

        Company company = companyRepository.findByUserId(userId)
            .orElse(new Company()); 
           
        company.setCompanyName(request.getCompanyName());
        company.setWebsite(request.getWebsite());
        company.setLocation(request.getLocation());
        company.setDescription(request.getDescription());
        
        company.setUser(user);
        
        Company savedCompany = companyRepository.save(company);
        
        return new CompanyResponse(
            savedCompany.getId(),
            savedCompany.getCompanyName(),
            savedCompany.getWebsite(),
            savedCompany.getLocation(),
            savedCompany.getDescription()
        );
    }

    @Override
    public CompanyResponse getCompany(Long userId){
        
        Company company = companyRepository.findByUserId(userId)
            .orElseThrow(()->new RuntimeException("Company Profile not found"));

        return new CompanyResponse(
            company.getId(),
            company.getCompanyName(),
            company.getWebsite(),
            company.getLocation(),
            company.getDescription()
        );    
    }

    @Override
    public void deleteCompany(Long userId) {

        Company company = companyRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Company profile not found"));

        companyRepository.delete(company);
    }

}
