package com.example.Task.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.Entity.Incident;
import com.example.Task.Repository.IncidentRepository;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public Incident saveIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> findByUserId(Long userId) {
        return incidentRepository.findByUserId(userId);
    }

    public Optional<Incident> findByIncidentId(String incidentId) {
        return incidentRepository.findByIncidentId(incidentId);
    }
}
