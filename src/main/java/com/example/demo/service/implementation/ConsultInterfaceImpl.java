package com.example.demo.service.implementation;

import com.example.demo.dto.ConsultDTO;
import com.example.demo.entity.Consult;
import com.example.demo.repository.IConsultRepository;
import com.example.demo.service.interfaces.ConsultInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultInterfaceImpl implements ConsultInterface {

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
       return consultRepository.findById(id).orElse(null);
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
