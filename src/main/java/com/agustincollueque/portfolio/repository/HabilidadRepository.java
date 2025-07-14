package com.agustincollueque.portfolio.repository;

import com.agustincollueque.portfolio.model.Habilidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {

    List<Habilidad> findByUserId(Long userId);
}
