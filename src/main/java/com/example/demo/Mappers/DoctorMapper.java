package com.example.demo.Mappers;

import com.example.demo.DTOs.DoctorDTO;
import com.example.demo.Entities.Doctor;
import com.example.demo.Resources.DoctorResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "email", target = "emailAddress")

    DoctorResource toResource(Doctor doctor);
    Doctor toEntity(DoctorDTO doctorDTO);
    DoctorDTO toDto(Doctor doctor);
}
