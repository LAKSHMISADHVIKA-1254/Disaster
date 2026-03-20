package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HelpRequest;

import com.example.demo.service.TaskService;
import com.example.demo.repository.HelpRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private HelpRepository repo;

    @Autowired
    private TaskService service;

    // ✅ ADMIN: GET ALL TASKS
    @GetMapping
    public List<HelpRequest> getAllTasks() {
        return repo.findAll();
    }

    // ✅ ADMIN: ASSIGN TASK
    @PutMapping("/assign/{taskId}/{responderId}")
    public HelpRequest assignTask(@PathVariable Long taskId,
                                 @PathVariable Long responderId) {
        return service.assignTask(taskId, responderId);
    }

    // ✅ RESPONDER: GET ASSIGNED TASKS
    @GetMapping("/responder/{id}")
    public List<HelpRequest> getTasks(@PathVariable Long id) {
        return service.getTasksByResponder(id);
    }

    // ✅ RESPONDER: SEND REPORT
    @PutMapping("/report/{id}")
    public HelpRequest sendReport(@PathVariable Long id,
                                 @RequestParam String report) {
        return service.submitReport(id, report);
    }

    // ✅ UPDATE STATUS (used in responder dashboard)
    @PutMapping("/{id}")
    public HelpRequest updateStatus(@PathVariable Long id,
                                   @RequestBody HelpRequest req) {

        HelpRequest existing = repo.findById(id).orElseThrow();
        existing.setStatus(req.getStatus());

        return repo.save(existing);
    }
}