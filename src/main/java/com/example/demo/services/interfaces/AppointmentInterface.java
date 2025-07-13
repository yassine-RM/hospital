package com.example.demo.services.interfaces;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entities.Appointment;
import com.example.demo.resources.AppointmentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppointmentInterface {

    public AppointmentResource create(AppointmentDTO appointmentDTO);
    public Appointment getAppointmentById(Long id);
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO);
    public void deleteAppointment(Long id);
    public Page<AppointmentResource> getAllAppointments(Pageable pageable);

}
