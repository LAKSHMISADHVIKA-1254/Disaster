package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.HelpRepository;
import com.example.demo.entity.HelpRequest;

import java.util.*;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin("*")
public class AnalyticsController {

    @Autowired
    private HelpRepository repo;

    @GetMapping
    public Map<String, Long> getAnalytics() {

        List<HelpRequest> list = repo.findAll();

        long total = list.size();
        long pending = list.stream().filter(r -> "PENDING".equals(r.getStatus())).count();
        long progress = list.stream().filter(r -> "IN_PROGRESS".equals(r.getStatus())).count();
        long completed = list.stream().filter(r -> "COMPLETED".equals(r.getStatus())).count();

        Map<String, Long> map = new HashMap<>();
        map.put("total", total);
        map.put("pending", pending);
        map.put("progress", progress);
        map.put("completed", completed);

        return map;
    }
}