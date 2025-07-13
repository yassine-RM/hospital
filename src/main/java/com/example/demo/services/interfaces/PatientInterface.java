package com.example.demo.services.interfaces;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entities.Patient;
import com.example.demo.resources.PatientResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientInterface {

    public Patient create(PatientDTO patientDTO);
    public Patient getPatientById(Long id);
    public Patient updatePatient(Long id, PatientDTO patientDTO);
    public void deletePatient(Long id);
    public Page<PatientResource> getAllPatients(Pageable pageable);

}
