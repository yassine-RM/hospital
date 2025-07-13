package com.example.demo.Repositories;

import com.example.demo.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor,Long> {
}
