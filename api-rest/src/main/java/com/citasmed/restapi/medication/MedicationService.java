package com.citasmed.restapi.medication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;

    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    public Optional<Medication> findById(Integer id) {
        return medicationRepository.findById(id);
    }

    public Medication save(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Medication updateMedication(Integer id, Medication updatedMedication) {
        Optional<Medication> existingMedicationOpt = medicationRepository.findById(id);

        if (existingMedicationOpt.isEmpty()) {
            throw new RuntimeException("Medication not found with ID: " + id);
        }

        Medication existingMedication = existingMedicationOpt.get();

        existingMedication.setName(updatedMedication.getName());
        existingMedication.setMeasurementId(updatedMedication.getMeasurementId());
        existingMedication.setIsActive(updatedMedication.getIsActive());

        return medicationRepository.save(existingMedication);
    }

    // This is a soft delete (for good practices)
    public Medication deleteById(Integer id) {
        Optional<Medication> existingMedicationOpt = medicationRepository.findById(id);

        if (existingMedicationOpt.isEmpty()) {
            throw new RuntimeException("Medication not found with ID: " + id);
        }

        Medication existingMedication = existingMedicationOpt.get();

        if (existingMedication.getIsActive()) {
            existingMedication.setIsActive(false);
        }

        return medicationRepository.save(existingMedication);
    }
}
