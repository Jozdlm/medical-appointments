package com.citasmed.restapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient/")
public class PatientController {
    @GetMapping("/")
    public String getPatients() {
        return "Get all patients";
    }
    
    @GetMapping("/{id}")
    public String getPatients(@PathVariable Integer id) {
        return "Get a patient with ID";
    }
    
    @PostMapping("/")
    public String createPatient() {
        return "Create a new patient";
    }

    @PutMapping("/{id}")
    public String updatePatient(@PathVariable Integer id) {
        return "Update patient with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Integer id) {
        return "Delete patient with ID: " + id;
    }
}
