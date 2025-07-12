package com.example.demo.controllers;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entities.Patient;
import com.example.demo.services.implementations.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping
    public Iterable<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody @Valid PatientDTO patientDTO) {
        System.out.println(
                patientDTO.getName() + " " + patientDTO.getEmail() + " " + patientDTO.getGender() + " " + patientDTO.getDob()
        );
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
