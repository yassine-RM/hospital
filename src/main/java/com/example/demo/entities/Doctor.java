package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String speciality;
    private int experience;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

}
