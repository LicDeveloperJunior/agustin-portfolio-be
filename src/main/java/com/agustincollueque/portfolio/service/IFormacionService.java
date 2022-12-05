package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import java.util.List;

public interface IFormacionService {
    public void crearFormacion(Formacion form);
    public void eliminarFormacion(Long id);
    public Formacion modificarFormacion(Formacion form);
    public Formacion obtenerFormacion(Long id);
    public List<Formacion>obtenerFormaciones();
}
