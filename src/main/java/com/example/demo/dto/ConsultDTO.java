package com.example.demo.dto;

import com.example.demo.entity.Appointment;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConsultDTO {

    @NotBlank(message = "Report is required")
    private String report;

    @NotBlank(message = "Appointment is required")
    private Appointment appointment;



}
