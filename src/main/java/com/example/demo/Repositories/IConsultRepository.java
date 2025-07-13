package com.example.demo.Repositories;

import com.example.demo.Entities.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultRepository extends JpaRepository<Consult,Long> {
}
