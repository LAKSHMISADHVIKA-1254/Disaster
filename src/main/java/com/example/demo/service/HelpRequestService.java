package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HelpRequest;
import com.example.demo.repository.HelpRepository;

import java.util.List;

@Service
public class HelpRequestService {

    @Autowired
    private HelpRepository repo;

    // ✅ SAVE REQUEST
    public HelpRequest saveRequest(HelpRequest request) {

        if (request.getStatus() == null) {
            request.setStatus("PENDING");
        }

        return repo.save(request);
    }

    // ✅ GET ALL (for admin/responder later)
    public List<HelpRequest> getAllRequests() {
        return repo.findAll();
    }
 // ✅ UPDATE STATUS
    public HelpRequest updateStatus(Long id, String status) {

        HelpRequest request = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus(status);

        return repo.save(request);
    }
}