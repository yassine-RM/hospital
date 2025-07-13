package com.example.demo.Mappers;

import com.example.demo.DTOs.PatientDTO;
import com.example.demo.Entities.Patient;
import com.example.demo.Resources.PatientResource;
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