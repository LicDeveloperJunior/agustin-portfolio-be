package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IFormacionService {

    Formacion crearFormacion(Usuario usuario, Formacion form);

    void eliminarFormacion(Long id);

    void modificarFormacion(Long id, Formacion form);

    Formacion obtenerFormacion(Long id);

    List<Formacion> obtenerFormaciones(Long userId);
}
