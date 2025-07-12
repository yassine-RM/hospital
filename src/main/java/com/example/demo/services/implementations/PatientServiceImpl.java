package com.example.demo.services.implementations;

import com.example.demo.dto.PatientDTO;
import com.example.demo.entities.Patient;
import com.example.demo.repositories.IPatientRepository;
import com.example.demo.services.interfaces.PatientInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientInterface {

    @Autowired
    private IPatientRepository patientRepository;

    /**
     * @param patient
     * @return Patient
     */
    @Override
    public Patient create(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setGender(patientDTO.getGender());
        patient.setDob(patientDTO.getDob());

        return patientRepository.save(patient);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Patient getPatientById(Long id) {

        return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found with id " + id));
    }

    /**
     * @param patientDTO, id
     * @return Patient
     */
    @Override
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(patientDTO.getName());
        patient.setEmail(patientDTO.getEmail());
        patient.setGender(patientDTO.getGender());
        patient.setDob(patientDTO.getDob());

        return patientRepository.save(patient);
    }


    /**
     * @param id
     */
    @Override
    public void deletePatient(Long id) {
         patientRepository.deleteById(id);
    }

    /**
     * @return List<Patient>
     */
    @Override
    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
