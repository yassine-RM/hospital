package com.example.demo.controllers;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entities.Appointment;
import com.example.demo.resources.AppointmentResource;
import com.example.demo.services.implementations.AppointmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @GetMapping
    public Page<AppointmentResource> getAllAppointments(Pageable pageable) {
        return appointmentService.getAllAppointments(pageable);
    }

    @PostMapping
    public AppointmentResource createAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return appointmentService.create(appointmentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestBody @Valid AppointmentDTO appointmentDTO
    ) {
        Appointment updated = appointmentService.updateAppointment(id, appointmentDTO);
        return ResponseEntity.ok(updated);
    }

}
