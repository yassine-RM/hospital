package com.example.demo.dto;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDTO {

    @NotNull(message = "Date is required")
    private Date date;


    @Valid
    @NotNull(message = "Patient is required")
    private Patient patient;

    @Valid
    @NotNull(message = "Doctor is required")
    private Doctor doctor;


}
