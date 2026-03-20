package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.Disaster;
import com.example.demo.repository.DisasterRepository;

@Service
public class DisasterService {

    @Autowired
    private DisasterRepository disasterRepository;

    // ✅ Save disaster
    public Disaster saveDisaster(Disaster disaster) {

        disaster.setReportedTime(LocalDateTime.now());

        return disasterRepository.save(disaster);
    }

    // ✅ Get all disasters (USED IN YOUR HTML)
    public List<Disaster> getAllDisasters() {
        return disasterRepository.findAll();
    }

    // ✅ Filter by type (optional)
    public List<Disaster> getByType(String type) {
        return disasterRepository.findByType(type);
    }

    // ✅ Filter by severity (matches your frontend)
    public List<Disaster> getBySeverity(String severity) {
        return disasterRepository.findBySeverity(severity);
    }
}