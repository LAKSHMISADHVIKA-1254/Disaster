package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Disaster;
import java.util.List;

public interface DisasterRepository extends JpaRepository<Disaster, Long> {

    // optional filters (future use)
    List<Disaster> findBySeverity(String severity);
    List<Disaster> findByType(String type);
}