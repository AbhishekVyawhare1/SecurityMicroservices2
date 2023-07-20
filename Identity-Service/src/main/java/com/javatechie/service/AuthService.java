package com.javatechie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javatechie.entity.UserCredentials;
import com.javatechie.repository.UserCredentialsRepository;

@Service
public class AuthService {

    @Autowired
    private UserCredentialsRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredentials credentials) {
        credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        repository.save(credentials);	
        return "User Added to System";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
