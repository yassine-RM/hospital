package com.example.demo.Services.Interfaces;

import com.example.demo.DTOs.AppointmentDTO;
import com.example.demo.Entities.Appointment;
import com.example.demo.Resources.AppointmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppointmentInterface {

    public Appointment create(AppointmentDTO appointmentDTO);
    public Appointment getAppointmentById(Long id);
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);
    public void deleteAppointment(Long id);
    public Page<AppointmentResource> getAllAppointments(Pageable pageable);

}
