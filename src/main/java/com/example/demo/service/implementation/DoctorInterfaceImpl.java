package com.example.demo.service.implementation;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.IDoctorRepository;
import com.example.demo.service.interfaces.DoctorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorInterfaceImpl implements DoctorInterface {

    @Autowired
    private IDoctorRepository doctorRepository;
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

        return doctorRepository.findById(id).orElse(null);
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
    public Iterable<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
