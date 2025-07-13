package com.example.demo.services.interfaces;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entities.Consult;
import com.example.demo.resources.ConsultResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsultInterface {

    public Consult create(ConsultDTO consultDTO);
    public Consult getConsultById(Long id);
    public Consult updateConsult(Long id, ConsultDTO consultDTO);
    public void deleteConsult(Long id);
    public Page<ConsultResource> getAllConsults(Pageable pageable);

}
