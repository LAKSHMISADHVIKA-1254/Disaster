package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Disaster;
import com.example.demo.service.DisasterService;

import java.util.List;

@RestController
@RequestMapping("/api/disasters")
@CrossOrigin("*")
public class DisasterController {

    @Autowired
    private DisasterService service;

    // ✅ CREATE ALERT (Admin)
    @PostMapping
    public Disaster create(@RequestBody Disaster disaster) {
        return service.saveDisaster(disaster);
    }

    // ✅ GET ALL ALERTS (Citizen)
    @GetMapping
    public List<Disaster> getAll() {
        return service.getAllDisasters();
    }
}