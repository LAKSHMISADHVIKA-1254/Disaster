package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HelpRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private HelpRepository repo;

    public Map<String, Object> getStats() {

        long total = repo.count();

        long pending = repo.findAll().stream()
                .filter(r -> "PENDING".equals(r.getStatus()))
                .count();

        long inProgress = repo.findAll().stream()
                .filter(r -> "APPROVED".equals(r.getStatus()))
                .count();

        long completed = repo.findAll().stream()
                .filter(r -> "DONE".equals(r.getStatus()))
                .count();

        Map<String, Object> data = new HashMap<>();
        data.put("totalRequests", total);
        data.put("pending", pending);
        data.put("inProgress", inProgress);
        data.put("completed", completed);
        data.put("totalAcknowledgements", 0); // update later

        return data;
    }
}