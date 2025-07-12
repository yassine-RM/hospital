package com.example.demo.repository;

import com.example.demo.entity.Consult;
import com.example.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultRepository extends JpaRepository<Consult,Long> {
}
