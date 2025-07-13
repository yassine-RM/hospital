package com.example.demo.controllers;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entities.Consult;
import com.example.demo.resources.ConsultResource;
import com.example.demo.services.implementations.ConsultServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consultations")
public class ConsultController {

    @Autowired
    private ConsultServiceImpl consultService;

    @GetMapping
    public Page<ConsultResource> getAllConsults(Pageable pageable) {
        return consultService.getAllConsults(pageable);
    }

    @PostMapping
    public Consult createConsult(@RequestBody @Valid ConsultDTO patientDTO) {
        return consultService.create(patientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteConsult(@PathVariable Long id) {
        consultService.deleteConsult(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consult> updateConsult(
            @PathVariable Long id,
            @RequestBody @Valid ConsultDTO patientDTO
    ) {
        Consult updated = consultService.updateConsult(id, patientDTO);
        return ResponseEntity.ok(updated);
    }

}
