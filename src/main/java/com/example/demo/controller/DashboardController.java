package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repository.HelpRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private HelpRepository repo;

    @GetMapping("/stats")
    public Map<String, Object> getStats() {

        long total = repo.count();

        long pending = repo.findAll().stream()
                .filter(r -> "PENDING".equals(r.getStatus()))
                .count();

        long inProgress = repo.findAll().stream()
                .filter(r -> "IN_PROGRESS".equals(r.getStatus()))
                .count();

        long completed = repo.findAll().stream()
                .filter(r -> "COMPLETED".equals(r.getStatus()))
                .count();

        return Map.of(
                "totalRequests", total,
                "pending", pending,
                "inProgress", inProgress,
                "completed", completed,
                "totalAcknowledgements", completed
        );
    }
}