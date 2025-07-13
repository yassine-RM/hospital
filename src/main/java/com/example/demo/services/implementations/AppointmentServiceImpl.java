package com.example.demo.services.implementations;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entities.Appointment;
import com.example.demo.mappers.AppointmentMapper;
import com.example.demo.mappers.PatientMapper;
import com.example.demo.repositories.IAppointmentRepository;
import com.example.demo.repositories.IPatientRepository;
import com.example.demo.resources.AppointmentResource;
import com.example.demo.services.interfaces.AppointmentInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentInterface {


    private final IAppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    AppointmentServiceImpl(
            IAppointmentRepository appointmentRepository,
            AppointmentMapper appointmentMapper
    ){
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }
    /**
     * @param appointmentDTO
     * @return
     */
    @Override
    public AppointmentResource create(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setStatus(appointmentDTO.getStatus());
        Appointment createdAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResource(createdAppointment);
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
    public Page<AppointmentResource> getAllAppointments(Pageable pageable) {

        return appointmentRepository.findAll(pageable)
                .map(appointmentMapper::toResource);
    }
}
