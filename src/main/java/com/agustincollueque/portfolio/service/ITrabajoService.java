package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.JobDto;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface ITrabajoService {

    JobDto crearTrabajo(Usuario usuario, JobDto trab);

    void eliminarTrabajo(Long id);

    JobDto modificarTrabajo(Long id, JobDto trab);

    JobDto obtenerTrabajo(Long id);

    List<JobDto> obtenerTrabajos(Long userId);
}
