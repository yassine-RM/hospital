package com.example.demo.resources;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentResource {
    private Patient patientData;
    private Doctor doctorData;
    private AppointmentStatus statusData;
}
