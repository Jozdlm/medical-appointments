package com.citasmed.restapi.appointment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments/")
public class AppointmentController {
    @GetMapping
    public String getAppointments() {
        return "Get all appointments";
    }

    @GetMapping("/{id}")
    public String getAppointmentById(@PathVariable Integer id) {
        return "Get appointment with ID: " + id;
    }

    @PostMapping
    public String createAppointment() {
        return "Create a new appointment";
    }

    @PutMapping("/{id}")
    public String updateAppointment(@PathVariable Integer id) {
        return "Update appointment with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Integer id) {
        return "Delete appointment with ID: " + id;
    }
}
