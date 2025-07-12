package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor,Long> {
}
