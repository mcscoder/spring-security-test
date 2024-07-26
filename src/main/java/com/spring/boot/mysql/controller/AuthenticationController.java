package com.spring.boot.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.mysql.dto.LoginRequest;
import com.spring.boot.mysql.dto.RegisterRequest;
import com.spring.boot.mysql.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserDetails> register(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    

    @PostMapping("/login")
    public ResponseEntity<UserDetails> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.login(loginRequest);
        return ResponseEntity.ok(userDetails);
    }

}
