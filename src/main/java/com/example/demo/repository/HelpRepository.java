package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.HelpRequest;

public interface HelpRepository extends JpaRepository<HelpRequest, Long> {

    List<HelpRequest> findByResponderId(Long responderId);
}