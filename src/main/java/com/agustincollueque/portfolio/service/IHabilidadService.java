package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    Habilidad crearHabilidad(Habilidad hab);
    void eliminarHabilidad(Long id);
    void modificarHabilidad(Habilidad hab);
    Habilidad obtenerHabilidad(Long id);
    List<Habilidad> obtenerHabilidades();
}
