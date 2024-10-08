package com.citasmed.restapi.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.citasmed.restapi.patient.ResourceNotFoundException;


import com.citasmed.restapi.patient.Patient;
import com.citasmed.restapi.patient.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Integer id, Patient updatedPatient) {
        Optional<Patient> existingPatientOpt = patientRepository.findById(id);

        if (existingPatientOpt.isEmpty()) {
            throw new RuntimeException("Patient not found with ID: " + id);
        }

        Patient existingPatient = existingPatientOpt.get();

        existingPatient.setNombre(updatedPatient.getNombre());

        return patientRepository.save(existingPatient);
    }

    // This is a soft delete (for good practices)
    public Patient deleteById(Integer id) {
        Optional<Patient> existingPatientOpt = patientRepository.findById(id);

        if (existingPatientOpt.isEmpty()) {
            throw new RuntimeException("Patient not found with ID: " + id);
        }

        Patient existingPatient = existingPatientOpt.get();

        // if (existingPatient.getIsActive()) {
        // existingPatient.setIsActive(false);
        // }
        //
        return patientRepository.save(existingPatient);
    }
}
