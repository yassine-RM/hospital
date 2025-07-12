package com.example.demo.services.implementations;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entities.Appointment;
import com.example.demo.repositories.IAppointmentRepository;
import com.example.demo.services.interfaces.AppointmentInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentInterface {

    @Autowired
    private IAppointmentRepository appointmentRepository;
    /**
     * @param appointmentDTO
     * @return
     */
    @Override
    public Appointment create(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setDate(appointmentDTO.getDate());

        return appointmentRepository.save(appointment);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment not found with id " + id));
    }

    /**
     * @param appointmentDTO, id
     * @return
     */
    @Override
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setDate(appointmentDTO.getDate());

        return appointmentRepository.save(appointment);
    }

    /**
     * @param id
     */
    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public Iterable<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }
}
