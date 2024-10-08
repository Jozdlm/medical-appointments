package com.citasmed.restapi.patient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient/")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getPatient() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Integer id) {
        Optional<Patient> patientOpt = patientService.findById(id);

        if (patientOpt.isEmpty()) {
            Map<String, String> errorResponse = Map.of(
                    "message", "Patient not found with ID: " + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(patientOpt.get());
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Integer id, @RequestBody Patient updatedPatient) {
        // Busca el paciente existente por ID
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));

        // Actualiza todos los campos o los neceasarios.
        existingPatient.setNombre(updatedPatient.getNombre());
        existingPatient.setApellido(updatedPatient.getApellido());
        existingPatient.setCui(updatedPatient.getCui());
        existingPatient.setTelefono(updatedPatient.getTelefono());
        existingPatient.setFechaNacimiento(updatedPatient.getFechaNacimiento());
        existingPatient.setCorreo(updatedPatient.getCorreo());
        existingPatient.setPassword(updatedPatient.getPassword());
        return patientRepository.save(existingPatient);
    }

    // @PutMapping("/{id}")
    // public Patient updatePatient(@PathVariable Integer id, @RequestBody Patient
    // patient) {
    // return patientService.
    // updatePatient(id, patient);
    // }

    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable Integer id) {
        return patientService.deleteById(id);
    }
}
