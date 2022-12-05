package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public void crearHabilidad(Habilidad hab);
    public void crearHabilidad(Habilidad hab, Long idUsuario);
    public void eliminarHabilidad(Long id);
    public Habilidad modificarHabilidad(Habilidad hab);
    public Habilidad obtenerHabilidad(Long id);
    public List<Habilidad> obtenerHabilidades();
}
