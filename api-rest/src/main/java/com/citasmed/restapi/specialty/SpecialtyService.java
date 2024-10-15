package com.citasmed.restapi.specialty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    public Optional<Specialty> findById(Integer id) {
        return specialtyRepository.findById(id);
    }

    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty updateSpecialty(Integer id, Specialty updatedSpecialty) {
        Optional<Specialty> existingSpecialtyOpt = specialtyRepository.findById(id);

        if (existingSpecialtyOpt.isEmpty()) {
            throw new RuntimeException("Specialty not found with ID: " + id);
        }

        Specialty existingSpecialty = existingSpecialtyOpt.get();

        existingSpecialty.setSpecialty(updatedSpecialty.getSpecialty());

        return specialtyRepository.save(existingSpecialty);
    }

    public Specialty deleteById(Integer id) {
        Optional<Specialty> existingSpecialtyOpt = specialtyRepository.findById(id);

        if (existingSpecialtyOpt.isEmpty()) {
            throw new RuntimeException("Specialty not found with ID: " + id);
        }

        Specialty existingSpecialty = existingSpecialtyOpt.get();
        specialtyRepository.deleteById(id); // Este método elimina el paciente de la base de datos.

        return existingSpecialty; // Opcional: Devuelve el paciente eliminado si lo necesitas.
    }

}
