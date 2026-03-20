package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HelpRequest;
import com.example.demo.repository.HelpRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HelpController {

    @Autowired
    private HelpRepository repo;

    // CREATE
    @PostMapping("/help")
    public HelpRequest create(@RequestBody HelpRequest request) {
        return repo.save(request);
    }

    // ✅ ADD THIS (VERY IMPORTANT)
    @GetMapping("/help")
    public List<HelpRequest> getAllHelpRequests() {
        return repo.findAll();
    }

}