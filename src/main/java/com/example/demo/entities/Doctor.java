package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Appointment> appointments;

}
