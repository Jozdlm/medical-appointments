package com.citasmed.restapi.receptionist;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService {

    @Autowired
    private ReceptionistRepository receptionistRepository;

    public List<Receptionist> findAll() {
        return receptionistRepository.findAll();
    }

    public Optional<Receptionist> findById(Integer id) {
        return receptionistRepository.findById(id);
    }

    public Receptionist save(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public Receptionist updateReceptionist(Integer id, Receptionist updatedReceptionist) {
        Optional<Receptionist> existingReceptionistOpt = receptionistRepository.findById(id);

        if (existingReceptionistOpt.isEmpty()) {
            throw new RuntimeException("Receptionist not found with ID: " + id);
        }

        Receptionist existingReceptionist = existingReceptionistOpt.get();

        existingReceptionist.setNombre(updatedReceptionist.getNombre());

        return receptionistRepository.save(existingReceptionist);
    }

    public Receptionist deleteById(Integer id) {
        Optional<Receptionist> existingReceptionistOpt = receptionistRepository.findById(id);

        if (existingReceptionistOpt.isEmpty()) {
            throw new RuntimeException("Receptionist not found with ID: " + id);
        }

        Receptionist existingReceptionist = existingReceptionistOpt.get();
        receptionistRepository.deleteById(id); // Este método elimina el paciente de la base de datos.

        return existingReceptionist; // Opcional: Devuelve el paciente eliminado si lo necesitas.
    }
}
