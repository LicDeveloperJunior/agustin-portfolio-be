package com.agustincollueque.portfolio.repository;

import com.agustincollueque.portfolio.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long>{}
