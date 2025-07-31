package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.ProjectDto;
import com.agustincollueque.portfolio.model.Proyecto;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.ProyectoRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Agustin Collueque
 */
@Service
@RequiredArgsConstructor
public class ProyectoService implements IProyectoService {

    private final ProyectoRepository proyRepo;
    private final HabilidadService skillService;

    @Transactional
    @Override
    public ProjectDto crearProyecto(Usuario usuario, ProjectDto proy) {
        return new ProjectDto(proyRepo.save(fromDto(proy, usuario)));
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public ProjectDto modificarProyecto(Long id, ProjectDto proy) {
        Proyecto projAux = proyRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("¡El proyecto no existe!"));
        loadProjectData(projAux, proy);
        return new ProjectDto(proyRepo.save(projAux));
    }

    @Override
    public List<ProjectDto> obtenerProyectos(Long userId) {
        return proyRepo.findByUserId(userId).stream()
                .map(ProjectDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto obtenerProyecto(Long id) {
        return new ProjectDto(proyRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project with ID " + id + " not found")));
    }

    public Proyecto fromDto(ProjectDto dto, Usuario usuario) {
        Proyecto proj = new Proyecto();
        loadProjectData(proj, dto);
        proj.setUser(usuario);
        return proj;
    }

    private void loadProjectData(Proyecto proj, ProjectDto dto) {
        proj.setTitle(dto.getTitle());
        proj.setDescription(dto.getDescription());
        proj.setStartDate(dto.getStartDate());
        proj.setEndDate(dto.getEndDate());
        proj.setLink(dto.getLink());
        proj.setUrlImg(dto.getUrlImg());
        proj.setTechnologies(skillService.getTechnologiesByIds(dto.getTechnologies()));
    }
}
