package com.example.demo.repositories;

import com.example.demo.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor,Long> {
}
