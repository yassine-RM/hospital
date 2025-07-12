package com.example.demo.controller;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entity.Appointment;
import com.example.demo.service.implementation.AppointmentInterfaceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentInterfaceImpl appointmentService;

    @GetMapping
    public Iterable<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody @Valid AppointmentDTO patientDTO) {
        return appointmentService.create(patientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestBody @Valid AppointmentDTO patientDTO
    ) {
        Appointment updated = appointmentService.updateAppointment(id, patientDTO);
        return ResponseEntity.ok(updated);
    }

}
