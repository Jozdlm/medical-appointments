package com.citasmed.restapi.appointment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment-status")
public class AppointmentStatusController {

    @GetMapping
    public String getAppointmentStatuses() {
        return "Get all appointment statuses";
    }

    @GetMapping("/{id}")
    public String getAppointmentStatusById(@PathVariable Integer id) {
        return "Get appointment status with ID: " + id;
    }

    @PostMapping
    public String createAppointmentStatus() {
        return "Create a new appointment status";
    }

    @PutMapping("/{id}")
    public String updateAppointmentStatus(@PathVariable Integer id) {
        return "Update appointment status with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteAppointmentStatus(@PathVariable Integer id) {
        return "Delete appointment status with ID: " + id;
    }
}
