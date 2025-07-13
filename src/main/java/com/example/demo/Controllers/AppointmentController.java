package com.example.demo.Controllers;

import com.example.demo.DTOs.AppointmentDTO;
import com.example.demo.Entities.Appointment;
import com.example.demo.Resources.AppointmentResource;
import com.example.demo.Services.Implementations.AppointmentServiceImpl;
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
    public Appointment createAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
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
