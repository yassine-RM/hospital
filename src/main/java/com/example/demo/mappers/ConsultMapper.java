package com.example.demo.mappers;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entities.Consult;
import com.example.demo.resources.ConsultResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultMapper {

    @Mapping(source = "report", target = "generatedReport")

    ConsultResource toResource(Consult consult);
    Consult toEntity(ConsultDTO consultDTO);
    ConsultDTO toDto(Consult consult);
}