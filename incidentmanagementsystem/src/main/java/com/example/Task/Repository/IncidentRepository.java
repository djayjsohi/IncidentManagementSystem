package com.example.Task.Repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task.Entity.*;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
	    List<Incident> findByUserId(Long userId);
	    Optional<Incident> findByIncidentId(String incidentId);
	}

