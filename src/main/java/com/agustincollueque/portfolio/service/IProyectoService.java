package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.ProjectDto;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

/**
 *
 * @author Agustin Collueque
 */
public interface IProyectoService {

    ProjectDto crearProyecto(Usuario usuario, ProjectDto proy);

    void eliminarProyecto(Long id);

    ProjectDto modificarProyecto(Long id, ProjectDto proy);

    ProjectDto obtenerProyecto(Long id);

    List<ProjectDto> obtenerProyectos(Long userId);
}
