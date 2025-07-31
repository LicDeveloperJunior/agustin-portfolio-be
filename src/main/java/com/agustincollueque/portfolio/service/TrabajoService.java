package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.JobDto;
import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.TrabajoRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TrabajoService implements ITrabajoService {
    
    private final TrabajoRepository trabRepo;
    private final HabilidadService skillService;
    
    @Transactional
    @Override
    public JobDto crearTrabajo(Usuario usuario, JobDto job) {
        return new JobDto(trabRepo.save(fromDto(job, usuario)));
    }
    
    @Transactional
    @Override
    public void eliminarTrabajo(Long id) {
        trabRepo.deleteById(id);
    }
    
    @Transactional
    @Override
    public JobDto modificarTrabajo(Long id, JobDto job) {
        Trabajo jobAux = trabRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job with ID " + id + " not found."));
        loadProjectData(jobAux, job);
        return new JobDto(trabRepo.save(jobAux));
    }
    
    @Override
    public JobDto obtenerTrabajo(Long id) {
        return new JobDto(trabRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job with ID " + id + " not found.")));
    }
    
    @Override
    public List<JobDto> obtenerTrabajos(Long userId) {
        return trabRepo.findByUserId(userId).stream()
                .map(JobDto::new)
                .collect(Collectors.toList());
    }
    
    public Trabajo fromDto(JobDto dto, Usuario usuario) {
        Trabajo job = new Trabajo();
        loadProjectData(job, dto);
        job.setUser(usuario);
        return job;
    }
    
    private void loadProjectData(Trabajo job, JobDto dto) {
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setStartDate(dto.getStartDate());
        job.setEndDate(dto.getEndDate());
        job.setUrlImg(dto.getUrlImg());
        job.setTechnologies(skillService.getTechnologiesByIds(dto.getTechnologies()));
    }
    
}
