package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Acknowledgement;
import com.example.demo.service.AcknowledgementService;

import java.util.List;

@RestController
@RequestMapping("/api/ack")
@CrossOrigin("*")
public class AcknowledgementController {

    @Autowired
    private AcknowledgementService service;

    // ✅ RESPONDER: SEND ACKNOWLEDGEMENT
    @GetMapping("/assign")
    public Acknowledgement assign(
            @RequestParam Long alertId,
            @RequestParam Long responderId) {

        return service.assign(alertId, responderId);
    }

    // ✅ ADMIN: VIEW ALL ACKNOWLEDGEMENTS
    @GetMapping
    public List<Acknowledgement> getAll(){
        return service.getAll();
    }
}