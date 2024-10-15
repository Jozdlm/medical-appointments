package com.citasmed.restapi.receptionist;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receptionist/")
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;
    @Autowired
    private ReceptionistRepository receptionistRepository;

    @GetMapping
    public List<Receptionist> getReceptionists() {
        return receptionistService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReceptionistById(@PathVariable Integer id) {
        Optional<Receptionist> receptionistOpt = receptionistService.findById(id);

        if (receptionistOpt.isEmpty()) {
            Map<String, String> errorResponse = Map.of(
                    "message", "Receptionist not found with ID: " + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(receptionistOpt.get());
    }

    @PostMapping
    public Receptionist createReceptionist(@RequestBody Receptionist receptionist) {
        return receptionistService.save(receptionist);
    }

    @PutMapping("/{id}")
    public Receptionist updateReceptionist(@PathVariable Integer id, @RequestBody Receptionist updatedReceptionist) {
        // Busca el recepcionista existente por ID
        Receptionist existingReceptionist = receptionistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receptionist not found with id " + id));

        // Actualiza todos los campos o los neceasarios.
        existingReceptionist.setNombre(updatedReceptionist.getNombre());
        existingReceptionist.setApellido(updatedReceptionist.getApellido());
        existingReceptionist.setCui(updatedReceptionist.getCui());
        existingReceptionist.setTelefono(updatedReceptionist.getTelefono());
        existingReceptionist.setCorreo(updatedReceptionist.getCorreo());
        existingReceptionist.setPassword(updatedReceptionist.getPassword());
        return receptionistRepository.save(updatedReceptionist);
    }

    // @PutMapping("/{id}")
    // public Receptionist updateReceptionist(@PathVariable Integer id, @RequestBody Receptionist
    // receptionist) {
    // return receptionistService.
    // updateReceptionist(id, receptionist);
    // }

    @DeleteMapping("/{id}")
    public Receptionist deleteReceptionist(@PathVariable Integer id) {
        return receptionistService.deleteById(id);
    }
}
