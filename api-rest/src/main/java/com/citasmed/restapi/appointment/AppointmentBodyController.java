package com.citasmed.restapi.appointment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments/{id}/appointment-body/")
public class AppointmentBodyController {
    @GetMapping
    public String getAppointmentBodyById(@PathVariable Integer id) {
        return "Get appointment detail with ID: " + id;
    }

    @PostMapping
    public String createAppointmentBody(@PathVariable Integer id) {
        return "Create a new appointment detail";
    }

    @PutMapping
    public String updateAppointmentBody(@PathVariable Integer id) {
        return "Update appointment detail with ID: " + id;
    }

    @DeleteMapping
    public String deleteAppointmentBody(@PathVariable Integer id) {
        return "Delete appointment detail with ID: " + id;
    }
}
