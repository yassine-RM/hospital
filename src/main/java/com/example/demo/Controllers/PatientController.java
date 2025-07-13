package com.example.demo.Controllers;

import com.example.demo.DTOs.PatientDTO;
import com.example.demo.Entities.Patient;
import com.example.demo.Resources.PatientResource;
import com.example.demo.Services.Implementations.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping
    public Page<PatientResource> getAllPatients(Pageable pageable) {
        return patientService.getAllPatients(pageable);
    }

    @PostMapping
    public Patient createPatient(@RequestBody @Valid PatientDTO patientDTO) {
        return patientService.create(patientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id,
            @RequestBody @Valid PatientDTO patientDTO
    ) {
        Patient updated = patientService.updatePatient(id, patientDTO);
        return ResponseEntity.ok(updated);
    }

}
