package com.example.demo.Services.Interfaces;

import com.example.demo.DTOs.DoctorDTO;
import com.example.demo.Entities.Doctor;
import com.example.demo.Resources.DoctorResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorInterface {

    public Doctor create(DoctorDTO doctorDTO);
    public Doctor getDoctorById(Long id);
    public Doctor updateDoctor(Long id, DoctorDTO doctorDTO);
    public void deleteDoctor(Long id);
    public Page<DoctorResource> getAllDoctors(Pageable pageable);

}
