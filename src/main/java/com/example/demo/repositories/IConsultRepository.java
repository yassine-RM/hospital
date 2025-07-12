package com.example.demo.repositories;

import com.example.demo.entities.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultRepository extends JpaRepository<Consult,Long> {
}
