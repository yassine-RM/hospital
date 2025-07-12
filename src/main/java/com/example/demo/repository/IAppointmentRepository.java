package com.example.demo.repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
}
