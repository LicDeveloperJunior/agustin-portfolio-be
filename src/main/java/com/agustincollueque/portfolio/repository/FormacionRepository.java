package com.agustincollueque.portfolio.repository;

import com.agustincollueque.portfolio.model.Formacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacionRepository extends JpaRepository<Formacion, Long> {

    List<Formacion> findByUserId(Long userId);
}
