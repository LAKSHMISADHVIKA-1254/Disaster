package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class HelpRequest {

	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String location;
	    private String description;
	    private String contact;
	    private String status; // PENDING, IN_PROGRESS, COMPLETED
	    private String report;

	    private Long responderId; // ✅ ADD THIS FIELD

	    // getters & setters

	    public Long getId() { return id; }

	    public String getLocation() { return location; }
	    public void setLocation(String location) { this.location = location; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public String getContact() { return contact; }
	    public void setContact(String contact) { this.contact = contact; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public String getReport() { return report; }
	    public void setReport(String report) { this.report = report; }

	    // ✅ NEW GETTER/SETTER
	    public Long getResponderId() { return responderId; }
	    public void setResponderId(Long responderId) { this.responderId = responderId; }
	}