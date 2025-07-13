package com.example.demo.Mappers;

import com.example.demo.DTOs.ConsultDTO;
import com.example.demo.Entities.Consult;
import com.example.demo.Resources.ConsultResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultMapper {

    @Mapping(source = "report", target = "generatedReport")

    ConsultResource toResource(Consult consult);
    Consult toEntity(ConsultDTO consultDTO);
    ConsultDTO toDto(Consult consult);
}