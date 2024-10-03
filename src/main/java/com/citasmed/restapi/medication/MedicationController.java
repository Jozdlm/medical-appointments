package com.citasmed.restapi.medication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @GetMapping
    public String getMedications() {
        return "Get all medications";
    }

    @GetMapping("/{id}")
    public String getMedicationById(@PathVariable Integer id) {
        return "Get medication with ID: " + id;
    }

    @PostMapping
    public String createMedication() {
        return "Create a new medication";
    }

    @PutMapping("/{id}")
    public String updateMedication(@PathVariable Integer id) {
        return "Update medication with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteMedication(@PathVariable Integer id) {
        return "Delete medication with ID: " + id;
    }
}
