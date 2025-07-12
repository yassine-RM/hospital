package com.example.demo.controller;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entity.Consult;
import com.example.demo.service.implementation.ConsultInterfaceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consults")
public class ConsultController {

    @Autowired
    private ConsultInterfaceImpl consultService;

    @GetMapping
    public Iterable<Consult> getAllConsults() {
        return consultService.getAllConsults();
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
