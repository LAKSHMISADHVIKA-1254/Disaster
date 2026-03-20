package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.entity.Alert;
import com.example.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin("*")
public class AlertController {

    @Autowired
    private AlertService alertService;

    // Admin creates alert
    @PostMapping("/create")
    public Alert createAlert(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    // Citizens view alerts
    @GetMapping
    public List<Alert> getAlerts() {
        return alertService.getAllAlerts();
    }
}