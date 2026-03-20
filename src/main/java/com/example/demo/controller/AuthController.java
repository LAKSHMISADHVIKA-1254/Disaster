package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.User;
import com.example.demo.entity.Role;   // ✅ IMPORT ENUM
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;
    
    // ✅ REGISTER API
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        // ✅ FIX: ENUM check (no isEmpty)
        if (user.getRole() == null) {
            user.setRole(Role.CITIZEN);   // ✅ ENUM VALUE
        }

        service.register(user);

        return ResponseEntity.ok(
                Map.of("message", "User Registered Successfully")
        );
    }

    // ✅ LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User login) {

        User user = service.findByEmail(login.getEmail());

        if (user != null &&
                encoder.matches(login.getPassword(), user.getPassword())) {

        	 String token = user.getEmail();  // ✅ simple token
        	// convert ENUM → String
        	String role = (user.getRole() != null)
        	    ? user.getRole().name()
        	    : "CITIZEN";

        	return ResponseEntity.ok(
        	    Map.of(
        	        "token", token,
        	        "role", role,
        	        "userId", user.getId()
        	    )
        	);

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid credentials"));
        }
    }
}