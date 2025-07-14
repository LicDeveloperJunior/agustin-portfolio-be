package com.agustincollueque.portfolio.repository;

import com.agustincollueque.portfolio.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Agustin Collueque
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByUserId(Long userId);
}
