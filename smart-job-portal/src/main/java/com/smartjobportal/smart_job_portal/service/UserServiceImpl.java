package com.smartjobportal.smart_job_portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartjobportal.smart_job_portal.dto.AuthResponse;
import com.smartjobportal.smart_job_portal.dto.LoginRequest;
import com.smartjobportal.smart_job_portal.dto.RegisterRequest;
import com.smartjobportal.smart_job_portal.entity.User;
import com.smartjobportal.smart_job_portal.exception.DuplicateEmailException;
import com.smartjobportal.smart_job_portal.repository.UserRepository;
import com.smartjobportal.smart_job_portal.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);

        return "User Registered Successfully";
    }    

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
         .orElseThrow(()->new RuntimeException("Invalid Email"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invallid Password");
        } 

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token, "Login Successful");
    }    
    
}
