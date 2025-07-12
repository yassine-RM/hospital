package com.example.demo.service.interfaces;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entity.Patient;

public interface PatientInterface {

    public Patient create(PatientDTO patientDTO);
    public Patient getPatientById(Long id);
    public Patient updatePatient(Long id, PatientDTO patientDTO);
    public void deletePatient(Long id);
    public Iterable<Patient> getAllPatients();

}
