package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Proyecto;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

/**
 *
 * @author Agustin Collueque
 */
public interface IProyectoService {

    Proyecto crearProyecto(Usuario usuario, Proyecto proy);

    void eliminarProyecto(Long id);

    void modificarProyecto(Long id, Proyecto proy);

    Proyecto obtenerProyecto(Long id);

    List<Proyecto> obtenerProyectos(Long userId);
}
