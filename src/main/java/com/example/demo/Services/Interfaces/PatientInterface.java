package com.example.demo.Services.Interfaces;

import com.example.demo.DTOs.PatientDTO;
import com.example.demo.Entities.Patient;
import com.example.demo.Resources.PatientResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientInterface {

    public Patient create(PatientDTO patientDTO);
    public Patient getPatientById(Long id);
    public Patient updatePatient(Long id, PatientDTO patientDTO);
    public void deletePatient(Long id);
    public Page<PatientResource> getAllPatients(Pageable pageable);

}
