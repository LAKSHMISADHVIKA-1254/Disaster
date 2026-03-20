package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Report;
import com.example.demo.repository.ReportRepository;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportRepository repo;

    // Add Report
    @PostMapping("/add")
    public Report addReport(@RequestBody Report report){
        return repo.save(report);
    }
    

    // Get All Reports
    @GetMapping("/all")
    public List<Report> getAllReports(){
        return repo.findAll();
    }
}