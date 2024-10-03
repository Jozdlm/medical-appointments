package com.citasmed.restapi.medication;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medications/")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @GetMapping
    public List<Medication> getMedications() {
        return medicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedicationById(@PathVariable Integer id) {
        Optional<Medication> medicationOpt = medicationService.findById(id);

        if (medicationOpt.isEmpty()) {
            Map<String, String> errorResponse = Map.of(
                    "message", "Medication not found with ID: " + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(medicationOpt.get());
    }

    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        return medicationService.save(medication);
    }

    @PutMapping("/{id}")
    public Medication updateMedication(@PathVariable Integer id, @RequestBody Medication medication) {
        return medicationService.updateMedication(id, medication);
    }

    @DeleteMapping("/{id}")
    public Medication deleteMedication(@PathVariable Integer id) {
        return medicationService.deleteById(id);
    }
}
