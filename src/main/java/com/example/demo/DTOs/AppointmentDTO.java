package com.example.demo.DTOs;

import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Patient;
import com.example.demo.Enums.AppointmentStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDTO {

    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Status is required")
    private AppointmentStatus status;


    @Valid
    @NotNull(message = "Patient is required")
    private Patient patient;

    @Valid
    @NotNull(message = "Doctor is required")
    private Doctor doctor;


}
