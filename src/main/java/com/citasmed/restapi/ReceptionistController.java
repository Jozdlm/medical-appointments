package com.citasmed.restapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receptionists/")
public class ReceptionistController {
    @GetMapping
    public String getReceptionists() {
        return "Get all receptionists";
    }

    @GetMapping("/{id}")
    public String getReceptionistById(@PathVariable Integer id) {
        return "Get receptionist with ID: " + id;
    }

    @PostMapping
    public String createReceptionist() {
        return "Create a new receptionist";
    }

    @PutMapping("/{id}")
    public String updateReceptionist(@PathVariable Integer id) {
        return "Update receptionist with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteReceptionist(@PathVariable Integer id) {
        return "Delete receptionist with ID: " + id;
    }
}
