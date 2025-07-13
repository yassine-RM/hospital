package com.example.demo.Services.Implementations;

import com.example.demo.DTOs.PatientDTO;
import com.example.demo.Entities.Patient;
import com.example.demo.Mappers.PatientMapper;
import com.example.demo.Repositories.IPatientRepository;
import com.example.demo.Resources.PatientResource;
import com.example.demo.Services.Interfaces.PatientInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientInterface {

    private final IPatientRepository patientRepository;
    private final PatientMapper patientMapper;

    PatientServiceImpl(
            IPatientRepository patientRepository,
            PatientMapper patientMapper
    ){
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    /**
     * @param patientDTO
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
    public Page<PatientResource> getAllPatients(Pageable pageable) {

        return patientRepository.findAll(pageable)
                .map(patientMapper::toResource);
    }
}
