package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;   // ✅
import org.springframework.http.ResponseEntity;                // ✅
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;                                         // ✅

import com.example.demo.entity.User;                          // ✅
import com.example.demo.entity.Role;                          // ✅
import com.example.demo.repository.UserRepository;            // ✅

@RestController
@RequestMapping("/api")   // ✅ better to keep /api
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profile() {
        return "Welcome! You are authenticated user.";
    }

    @GetMapping("/responders")
    public ResponseEntity<?> getResponders(){

        List<User> responders = userRepository.findByRole(Role.RESPONDER);

        return ResponseEntity.ok(responders);
    }
}