package com.example.Task.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String incidentId;
    private String reporterName;
    private String details;
    private LocalDateTime reportedDateTime;
    private String priority;
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    
    public Incident(Long id, String incidentId, String reporterName, String details, LocalDateTime reportedDateTime,
			String priority, String status, User user) {
		super();
		this.id = id;
		this.incidentId = incidentId;
		this.reporterName = reporterName;
		this.details = details;
		this.reportedDateTime = reportedDateTime;
		this.priority = priority;
		this.status = status;
		this.user = user;
	}
    
    
	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	public String getReporterName() {
		return reporterName;
	}
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDateTime getReportedDateTime() {
		return reportedDateTime;
	}
	public void setReportedDateTime(LocalDateTime reportedDateTime) {
		this.reportedDateTime = reportedDateTime;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    
    
    
    
    
    
    
    
    
}