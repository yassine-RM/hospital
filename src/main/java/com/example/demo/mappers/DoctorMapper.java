package com.example.demo.mappers;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.entities.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDto(Doctor doctor);
    Doctor toEntity(DoctorDTO dto);
}
