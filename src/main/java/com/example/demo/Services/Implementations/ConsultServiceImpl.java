package com.example.demo.Services.Implementations;

import com.example.demo.DTOs.ConsultDTO;
import com.example.demo.Entities.Consult;
import com.example.demo.Mappers.ConsultMapper;
import com.example.demo.Repositories.IConsultRepository;
import com.example.demo.Resources.ConsultResource;
import com.example.demo.Services.Interfaces.ConsultInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsultServiceImpl implements ConsultInterface {

    private final IConsultRepository consultRepository;
    private final ConsultMapper consultMapper;

    ConsultServiceImpl(
            IConsultRepository consultRepository,
            ConsultMapper consultMapper
    ){
        this.consultRepository = consultRepository;
        this.consultMapper = consultMapper;
    }


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
    public Page<ConsultResource> getAllConsults(Pageable pageable) {

        return consultRepository.findAll(pageable)
                .map(consultMapper::toResource);
    }
}
