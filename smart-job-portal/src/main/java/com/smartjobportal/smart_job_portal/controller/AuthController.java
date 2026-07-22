package com.smartjobportal.smart_job_portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjobportal.smart_job_portal.dto.AuthResponse;
import com.smartjobportal.smart_job_portal.dto.LoginRequest;
import com.smartjobportal.smart_job_portal.dto.RegisterRequest;
import com.smartjobportal.smart_job_portal.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register (@Valid @RequestBody RegisterRequest request){
        String message = userService.register(request);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

}
