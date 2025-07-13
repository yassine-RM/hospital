package com.example.demo.Services.Interfaces;

import com.example.demo.DTOs.ConsultDTO;
import com.example.demo.Entities.Consult;
import com.example.demo.Resources.ConsultResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsultInterface {

    public Consult create(ConsultDTO consultDTO);
    public Consult getConsultById(Long id);
    public Consult updateConsult(Long id, ConsultDTO consultDTO);
    public void deleteConsult(Long id);
    public Page<ConsultResource> getAllConsults(Pageable pageable);

}
