package com.smartjobportal.smart_job_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.StudentProfileRequest;
import com.smartjobportal.smart_job_portal.dto.StudentProfileResponse;
import com.smartjobportal.smart_job_portal.entity.StudentProfile;
import com.smartjobportal.smart_job_portal.entity.User;
import com.smartjobportal.smart_job_portal.repository.StudentRepository;
import com.smartjobportal.smart_job_portal.repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public StudentProfileResponse createOrUpdateProfile(Long userId, StudentProfileRequest request) {

        User user = userRepository.findById(userId)
            .orElseThrow(()->new RuntimeException("User Not Found"));

        StudentProfile profile = studentRepository.findByUser(user)
            .orElse(new StudentProfile());
        
        profile.setCollege(request.getCollege());
        profile.setDegree(request.getDegree());
        profile.setBranch(request.getBranch());
        profile.setSkills(request.getSkills());
        profile.setPhone(request.getPhone());
        profile.setGithub(request.getGithub());
        profile.setLinkedin(request.getLinkedin());
        profile.setAddress(request.getAddress());
        profile.setAbout(request.getAbout());   

        profile.setUser(user);

        StudentProfile savedProfile = studentRepository.save(profile);

        return new StudentProfileResponse(
            savedProfile.getId(),
            savedProfile.getCollege(),
            savedProfile.getDegree(),
            savedProfile.getBranch(),
            savedProfile.getSkills(),
            savedProfile.getPhone(),
            savedProfile.getGithub(),
            savedProfile.getLinkedin(),
            savedProfile.getAddress(),
            savedProfile.getAbout()
        );
    }


    @Override
    public StudentProfileResponse getProfile(Long userId) {

        User user = userRepository.findById(userId)
            .orElseThrow(()->new RuntimeException("User Not Found"));

        StudentProfile profile = studentRepository.findByUser(user)
            .orElseThrow(()->new RuntimeException("Profile Not Found"));

        return new StudentProfileResponse(
            profile.getId(),
            profile.getCollege(),
            profile.getDegree(),
            profile.getBranch(),
            profile.getSkills(),
            profile.getPhone(),
            profile.getGithub(),
            profile.getLinkedin(),
            profile.getAddress(),
            profile.getAbout()
        );    
    }


    @Override
    public void deleteProfile(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(()->new RuntimeException("User Not Found"));

        StudentProfile profile = studentRepository.findByUser(user)
            .orElseThrow(()->new RuntimeException("Profile Not Found"));

        studentRepository.delete(profile);    
    }
}
