package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.HelpRequest;
import com.example.demo.repository.HelpRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private HelpRepository repo;

    public HelpRequest assignTask(Long taskId, Long responderId) {
        HelpRequest req = repo.findById(taskId).orElseThrow();
        req.setResponderId(responderId);
        req.setStatus("IN_PROGRESS");
        return repo.save(req);
    }

    public List<HelpRequest> getTasksByResponder(Long id) {
        List<HelpRequest> all = repo.findAll();

        System.out.println("All tasks: " + all.size());

        List<HelpRequest> filtered = all.stream()
                .filter(r -> id.equals(r.getResponderId()))
                .toList();

        System.out.println("Filtered tasks: " + filtered.size());

        return filtered;
    }

    public HelpRequest submitReport(Long id, String report) {
        HelpRequest req = repo.findById(id).orElseThrow();
        req.setReport(report);
        req.setStatus("COMPLETED");
        return repo.save(req);
    }
}