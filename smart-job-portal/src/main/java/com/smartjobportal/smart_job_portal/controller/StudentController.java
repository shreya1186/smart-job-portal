package com.smartjobportal.smart_job_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smartjobportal.smart_job_portal.dto.StudentProfileRequest;
import com.smartjobportal.smart_job_portal.dto.StudentProfileResponse;

import com.smartjobportal.smart_job_portal.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PutMapping("/profile/{userId}")
    public StudentProfileResponse createOrUpdateProfile(
        @PathVariable Long userId,
        @RequestBody StudentProfileRequest request){

            return studentService.createOrUpdateProfile(userId, request);
    }

    @GetMapping("/profile/{userId}")
    public StudentProfileResponse getProfile(@PathVariable Long userId){
        return studentService.getProfile(userId);
    }

    @DeleteMapping("/profile/{userId}")
    public String deleteProfile(@PathVariable Long userId) {

        studentService.deleteProfile(userId);
        return "Profile Deleted Successfully";
    }
    
}
