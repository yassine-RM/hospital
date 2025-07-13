package com.example.demo.services.interfaces;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entities.Doctor;
import com.example.demo.resources.DoctorResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorInterface {

    public Doctor create(DoctorDTO doctorDTO);
    public Doctor getDoctorById(Long id);
    public Doctor updateDoctor(Long id, DoctorDTO doctorDTO);
    public void deleteDoctor(Long id);
    public Page<DoctorResource> getAllDoctors(Pageable pageable);

}
