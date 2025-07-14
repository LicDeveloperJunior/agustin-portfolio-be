package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface ITrabajoService {

    Trabajo crearTrabajo(Usuario usuario, Trabajo trab);

    void eliminarTrabajo(Long id);

    void modificarTrabajo(Long id, Trabajo trab);

    Trabajo obtenerTrabajo(Long id);

    List<Trabajo> obtenerTrabajos(Long userId);
}
