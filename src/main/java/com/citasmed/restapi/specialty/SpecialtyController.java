package com.citasmed.restapi.specialty;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/specialty/")

public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private SpecialtyRepository specialtyRepository;

    @GetMapping
    public List<Specialty> getSpecialtys() {
        return specialtyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecialtyById(@PathVariable Integer id) {
        Optional<Specialty> specialtyOpt = specialtyService.findById(id);

        if (specialtyOpt.isEmpty()) {
            Map<String, String> errorResponse = Map.of(
                    "message", "Specialty not found with ID: " + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(specialtyOpt.get());
    }

    @PostMapping
    public Specialty createSpecialty(@RequestBody Specialty specialty) {
        return specialtyService.save(specialty);
    }

    @PutMapping("/{id}")
    public Specialty updateSpecialty(@PathVariable Integer id, @RequestBody Specialty updatedSpecialty) {
        // Busca el recepcionista existente por ID
        Specialty existingSpecialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specialty not found with id " + id));

        // Actualiza todos los campos o los neceasarios.
        existingSpecialty.setSpecialty(updatedSpecialty.getSpecialty());
        return specialtyRepository.save(updatedSpecialty);
    }

    // @PutMapping("/{id}")
    // public Specialty updateSpecialty(@PathVariable Integer id, @RequestBody Specialty
    // specialty) {
    // return specialtyService.
    // updateSpecialty(id, specialty);
    // }

    @DeleteMapping("/{id}")
    public Specialty deleteSpecialty(@PathVariable Integer id) {
        return specialtyService.deleteById(id);
    }

}
