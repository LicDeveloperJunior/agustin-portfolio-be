package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.SkillDto;
import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Proyecto;
import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.HabilidadRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HabilidadService implements IHabilidadService {

    private final HabilidadRepository habRepo;

    @Transactional
    @Override
    public SkillDto crearHabilidad(Usuario usuario, SkillDto skill) {
        return new SkillDto(habRepo.save(fromDto(skill, usuario)));
    }

    @Transactional
    @Override
    public void eliminarHabilidad(Long id) {
        Habilidad habilidad = getSkillById(id);
        for (Proyecto proyecto : habilidad.getProjects()) {
            proyecto.getTechnologies().remove(habilidad);
        }
        for (Trabajo trabajo : habilidad.getJobs()) {
            trabajo.getTechnologies().remove(habilidad);
        }
        for (Formacion formacion : habilidad.getFormations()) {
            formacion.getTechnologies().remove(habilidad);
        }
        habilidad.getProjects().clear();
        habilidad.getJobs().clear();
        habilidad.getFormations().clear();

        habRepo.delete(habilidad);
    }

    @Transactional
    @Override
    public SkillDto modificarHabilidad(Long id, SkillDto skillUpdated) {
        Habilidad skillAux = getSkillById(id);
        loadSkillData(skillAux, skillUpdated);
        return new SkillDto(habRepo.save(skillAux));
    }

    @Override
    public SkillDto obtenerHabilidad(Long id) {
        return new SkillDto(getSkillById(id));
    }

    @Override
    public List<SkillDto> obtenerHabilidades(Long userId) {
        return habRepo.findByUserId(userId).stream()
                .map(SkillDto::new)
                .collect(Collectors.toList());
    }

    public Habilidad fromDto(SkillDto dto, Usuario usuario) {
        Habilidad skill = new Habilidad();
        loadSkillData(skill, dto);
        skill.setUser(usuario);
        return skill;
    }

    private void loadSkillData(Habilidad skill, SkillDto dto) {
        skill.setName(dto.getName());
        skill.setUrlLogo(dto.getUrlLogo());
        skill.setLearning(dto.isLearning());
        skill.setType(dto.getType());
        skill.setSkills(dto.getSkills());
    }

    public Set<Habilidad> getTechnologiesByIds(List<Long> ids) {
        return new HashSet<>(habRepo.findAllById(ids));
    }

    private Habilidad getSkillById(Long id) {
        return habRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Skill with ID " + id + " not found"));
    }
}
