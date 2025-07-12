package com.example.demo.services.interfaces;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entities.Consult;

public interface ConsultInterface {

    public Consult create(ConsultDTO consultDTO);
    public Consult getConsultById(Long id);
    public Consult updateConsult(Long id, ConsultDTO consultDTO);
    public void deleteConsult(Long id);
    public Iterable<Consult> getAllConsults();

}
