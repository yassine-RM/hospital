package com.example.demo.Resources;

import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Patient;
import com.example.demo.Enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentResource {
    private Patient patientData;
    private Doctor doctorData;
    private AppointmentStatus statusData;
}
