package com.example.demo.services.implementations;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entities.Consult;
import com.example.demo.repositories.IConsultRepository;
import com.example.demo.services.interfaces.ConsultInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultServiceImpl implements ConsultInterface {

    @Autowired
    private IConsultRepository consultRepository;
    /**
     * @param consultDTO
     * @return
     */
    @Override
    public Consult create(ConsultDTO consultDTO) {

        Consult consult = new Consult();
        consult.setReport(consultDTO.getReport());
        consult.setAppointment(consultDTO.getAppointment());

        return consultRepository.save(consult);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Consult getConsultById(Long id) {
       return consultRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consultation not found with id " + id));
    }

    /**
     * @param consultDTO, id
     * @return
     */
    @Override
    public Consult updateConsult(Long id, ConsultDTO consultDTO) {

        Consult consult = consultRepository.findById(id).orElseThrow(() -> new RuntimeException("Consult not found"));
        consult.setReport(consultDTO.getReport());
        consult.setAppointment(consultDTO.getAppointment());
        return consultRepository.save(consult);
    }

    /**
     * @param id
     */
    @Override
    public void deleteConsult(Long id) {
        consultRepository.deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public Iterable<Consult> getAllConsults() {
        return consultRepository.findAll();
    }
}
