package com.example.demo.mappers;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.entities.Appointment;
import com.example.demo.resources.AppointmentResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "patient", target = "patientData")
    @Mapping(source = "doctor", target = "doctorData")
    @Mapping(source = "status", target = "statusData")

    AppointmentResource toResource(Appointment appointment);
    Appointment toEntity(AppointmentDTO appointmentDTO);
    AppointmentDTO toDto(Appointment appointment);
}