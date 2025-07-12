package com.example.demo.services.implementations;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entities.Doctor;
import com.example.demo.mappers.DoctorMapper;
import com.example.demo.repositories.IDoctorRepository;
import com.example.demo.services.interfaces.DoctorInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorInterface {

    private final IDoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;


    public DoctorServiceImpl(
            IDoctorRepository doctorRepository,
            DoctorMapper doctorMapper
    ) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    /**
     * @param doctorDTO
     * @return
     */
    @Override
    public Doctor create(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        doctor.setExperience(doctorDTO.getExperience());

        return doctorRepository.save(doctor);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Doctor getDoctorById(Long id) {

        return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + id));
    }

    /**
     * @param id,doctorDTO
     * @return
     */
    @Override
    public Doctor updateDoctor(Long id, DoctorDTO doctorDTO) {

        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setName(doctorDTO.getName());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        doctor.setExperience(doctorDTO.getExperience());

        return doctorRepository.save(doctor);

    }

    /**
     * @param id
     */
    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public Page<DoctorDTO> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable)
                .map(doctorMapper::toDto);
    }
}
