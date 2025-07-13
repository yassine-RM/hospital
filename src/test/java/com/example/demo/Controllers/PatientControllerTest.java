package com.example.demo.Controllers;

import com.example.demo.DTOs.PatientDTO;
import com.example.demo.Entities.Patient;
import com.example.demo.Enums.Gender;
import com.example.demo.Services.Implementations.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PatientServiceImpl patientService;

    @Test
    void shouldReturn201WhenPatientIsCreated() throws Exception {
        // Arrange - input DTO
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("yassine");
        patientDTO.setEmail("yassine@gmail.com");
        patientDTO.setGender(Gender.MALE);
        patientDTO.setDob("2021-01-01");

        // Expected response from service
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("yassine");
        patient.setEmail("yassine@gmail.com");
        patient.setGender(Gender.MALE);
        patient.setDob("2021-01-01");

        // Mock the service behavior
        when(patientService.create(any(PatientDTO.class))).thenReturn(patient);

        // Act & Assert - perform POST request and verify response
        mockMvc.perform(post("/api/v1/patients") // ← Update this to your actual POST endpoint
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patientDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("yassine"))
                .andExpect(jsonPath("$.email").value("yassine@gmail.com"))
                .andExpect(jsonPath("$.gender").value("MALE"));

        verify(patientService).create(any(PatientDTO.class));
    }
}
