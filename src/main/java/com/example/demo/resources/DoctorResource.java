package com.example.demo.resources;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorResource {
    private Long id;
    private String fullName;
    private String emailAddress;
}
