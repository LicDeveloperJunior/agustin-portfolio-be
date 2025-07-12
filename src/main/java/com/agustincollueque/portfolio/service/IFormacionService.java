package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import java.util.List;

public interface IFormacionService {
    Formacion crearFormacion(Formacion form);
    void eliminarFormacion(Long id);
    void modificarFormacion(Formacion form);
    Formacion obtenerFormacion(Long id);
    List<Formacion>obtenerFormaciones();
}
