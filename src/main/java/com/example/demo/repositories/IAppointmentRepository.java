package com.example.demo.repositories;

import com.example.demo.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
}
