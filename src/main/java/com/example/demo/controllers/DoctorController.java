package com.example.demo.controllers;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entities.Doctor;
import com.example.demo.resources.DoctorResource;
import com.example.demo.services.implementations.DoctorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping
    public Page<DoctorResource> getAllDoctors(Pageable pageable) {
        return doctorService.getAllDoctors(pageable);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return doctorService.create(doctorDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody @Valid DoctorDTO doctorDTO
    ) {
        Doctor updated = doctorService.updateDoctor(id, doctorDTO);
        return ResponseEntity.ok(updated);
    }

}
