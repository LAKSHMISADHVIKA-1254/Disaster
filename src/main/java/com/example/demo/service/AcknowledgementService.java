package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Acknowledgement;
import com.example.demo.repository.AcknowledgementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AcknowledgementService {

    @Autowired
    private AcknowledgementRepository repo;

    // ✅ CREATE ACKNOWLEDGEMENT
    public Acknowledgement assign(Long alertId, Long responderId){

        Acknowledgement ack = new Acknowledgement();
        ack.setAlertId(alertId);
        ack.setResponderId(responderId);
        ack.setAcknowledgedAt(LocalDateTime.now());

        return repo.save(ack);
    }

    // ✅ GET ALL
    public List<Acknowledgement> getAll(){
        return repo.findAll();
    }
}