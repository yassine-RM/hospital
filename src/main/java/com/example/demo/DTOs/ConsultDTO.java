package com.example.demo.DTOs;

import com.example.demo.Entities.Appointment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsultDTO {

    @NotBlank(message = "Report is required")
    private String report;

    @NotNull(message = "Appointment is required")
    @Valid
    private Appointment appointment;



}
