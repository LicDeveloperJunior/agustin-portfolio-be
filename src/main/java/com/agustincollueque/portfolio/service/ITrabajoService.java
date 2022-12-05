package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Trabajo;
import java.util.List;

public interface ITrabajoService {
    public void crearTrabajo(Trabajo trab);
    public void eliminarTrabajo(Long id);
    public Trabajo modificarTrabajo(Trabajo trab);
    public Trabajo obtenerTrabajo(Long id);
    public List<Trabajo> obtenerTrabajos();
}
