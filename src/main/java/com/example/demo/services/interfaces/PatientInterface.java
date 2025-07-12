package com.example.demo.services.interfaces;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entities.Patient;

public interface PatientInterface {

    public Patient create(PatientDTO patientDTO);
    public Patient getPatientById(Long id);
    public Patient updatePatient(Long id, PatientDTO patientDTO);
    public void deletePatient(Long id);
    public Iterable<Patient> getAllPatients();

}
