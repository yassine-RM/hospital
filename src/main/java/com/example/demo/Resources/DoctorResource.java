package com.example.demo.Resources;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorResource {
    private Long id;
    private String fullName;
    private String emailAddress;
}
