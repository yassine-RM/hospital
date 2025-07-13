package com.example.demo.Mappers;

import com.example.demo.DTOs.AppointmentDTO;
import com.example.demo.Entities.Appointment;
import com.example.demo.Resources.AppointmentResource;
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