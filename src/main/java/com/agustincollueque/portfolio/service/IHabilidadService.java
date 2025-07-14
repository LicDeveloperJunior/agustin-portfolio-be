package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IHabilidadService {

    Habilidad crearHabilidad(Usuario usuario, Habilidad hab);

    void eliminarHabilidad(Long id);

    void modificarHabilidad(Long id, Habilidad hab);

    Habilidad obtenerHabilidad(Long id);

    List<Habilidad> obtenerHabilidades(Long userId);
}
