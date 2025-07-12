package com.example.demo.controller;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;
import com.example.demo.service.implementation.DoctorInterfaceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorInterfaceImpl doctorService;

    @GetMapping
    public Iterable<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody @Valid DoctorDTO patientDTO) {
        return doctorService.create(patientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody @Valid DoctorDTO patientDTO
    ) {
        Doctor updated = doctorService.updateDoctor(id, patientDTO);
        return ResponseEntity.ok(updated);
    }

}
