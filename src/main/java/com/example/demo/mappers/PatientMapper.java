package com.example.demo.mappers;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.resources.PatientResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "email", target = "emailAddress")

    PatientResource toResource(Patient patient);
    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toDto(Patient patient);
}