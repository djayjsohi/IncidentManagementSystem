package com.example.Task.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Task.Entity.Incident;
import com.example.Task.Entity.User;
import com.example.Task.Service.IncidentService;
import com.example.Task.Service.UserService;

/*
 * import java.time.LocalDateTime; import java.util.List; import
 * java.util.Random;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.Task.Entity.Incident; import
 * com.example.Task.Service.IncidentService;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/incidents") public class IncidentController {
 * 
 * @Autowired private IncidentService incidentService;
 * 
 * @PostMapping("/create") public ResponseEntity<Incident>
 * createIncident(@RequestBody Incident incident) { // Generate unique Incident
 * ID String incidentId = "RMG" + new Random().nextInt(100000) + "2022";
 * incident.setIncidentId(incidentId);
 * incident.setReportedDateTime(LocalDateTime.now()); return
 * ResponseEntity.ok(incidentService.saveIncident(incident)); }
 * 
 * @GetMapping("/user/{userId}") public ResponseEntity<List<Incident>>
 * getIncidentsByUser(@PathVariable Long userId) { return
 * ResponseEntity.ok(incidentService.findByUserId(userId)); }
 * 
 * // other endpoints like update, delete }
 */


@Controller
public class IncidentController {
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private UserService userService;

    @GetMapping("/incidents")
    public String showIncidentForm(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("incident", new Incident(null, null, null, null, null, null, null, user));
        model.addAttribute("incidents", incidentService.findByUserId(user.getId()));
        return "incident-management";
    }

    @PostMapping("/incidents")
    public String createIncident(@ModelAttribute Incident incident, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        incident.setUser(user);
        incident.setIncidentId("RMG" + new Random().nextInt(100000) + "2022");
        incident.setReportedDateTime(LocalDateTime.now());
        incidentService.saveIncident(incident);
        return "redirect:/incidents";
    }
}