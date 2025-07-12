package com.example.demo.service.interfaces;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entity.Doctor;

public interface DoctorInterface {

    public Doctor create(DoctorDTO doctorDTO);
    public Doctor getDoctorById(Long id);
    public Doctor updateDoctor(Long id, DoctorDTO doctorDTO);
    public void deleteDoctor(Long id);
    public Iterable<Doctor> getAllDoctors();

}
