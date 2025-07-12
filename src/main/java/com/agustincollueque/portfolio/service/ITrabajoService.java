package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Trabajo;
import java.util.List;

public interface ITrabajoService {
    Trabajo crearTrabajo(Trabajo trab);
    void eliminarTrabajo(Long id);
    void modificarTrabajo(Trabajo trab);
    Trabajo obtenerTrabajo(Long id);
    List<Trabajo> obtenerTrabajos();
}
