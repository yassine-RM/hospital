package com.example.demo.service.interfaces;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entity.Appointment;

public interface AppointmentInterface {

    public Appointment create(AppointmentDTO appointmentDTO);
    public Appointment getAppointmentById(Long id);
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);
    public void deleteAppointment(Long id);
    public Iterable<Appointment> getAllAppointments();

}
