package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.FormationDto;
import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.FormacionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FormacionService implements IFormacionService {

    private final FormacionRepository formRepo;
    private final HabilidadService habServ;

    @Transactional
    @Override
    public FormationDto crearFormacion(Usuario usuario, FormationDto form) {
        return new FormationDto(formRepo.save(fromDto(form, usuario)));
    }

    @Transactional
    @Override
    public void eliminarFormacion(Long id) {
        formRepo.deleteById(id);
    }

    @Transactional
    @Override
    public FormationDto modificarFormacion(Long id, FormationDto form) {
        Formacion formAux = getFormationById(id);
        loadFormationData(formAux, form);
        return new FormationDto(formRepo.save(formAux));
    }

    @Override
    public FormationDto obtenerFormacion(Long id) {
        return new FormationDto(getFormationById(id));
    }

    @Override
    public List<FormationDto> obtenerFormaciones(Long userId) {
        return formRepo.findByUserId(userId).stream()
                .map(FormationDto::new)
                .collect(Collectors.toList());
    }

    public Formacion fromDto(FormationDto dto, Usuario usuario) {
        Formacion formation = new Formacion();
        loadFormationData(formation, dto);
        formation.setUser(usuario);
        return formation;
    }

    private void loadFormationData(Formacion form, FormationDto dto) {
        form.setTitle(dto.getTitle());
        form.setAcademy(dto.getAcademy());
        form.setDescription(dto.getDescription());
        form.setType(dto.getType());
        form.setStartDate(dto.getStartDate());
        form.setEndDate(dto.getEndDate());
        form.setTechnologies(habServ.getTechnologiesByIds(dto.getTechnologies()));
    }
    
    private Formacion getFormationById(Long id) {
        return formRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formation with ID " + id + " not found."));
    }
}
