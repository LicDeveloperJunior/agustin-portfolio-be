package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.HabilidadRepository;
import java.util.List;
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
    public Habilidad crearHabilidad(Usuario usuario, Habilidad hab) {
        hab.setUser(usuario);
        return habRepo.save(hab);
    }

    @Transactional
    @Override
    public void eliminarHabilidad(Long id) {
        habRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void modificarHabilidad(Long id, Habilidad hab) {
        if (!habRepo.existsById(id)) {
            throw new EntityNotFoundException("¡La habilidad no existe! No se puede modificar.");
        }
        habRepo.save(hab);
    }

    @Override
    public Habilidad obtenerHabilidad(Long id) {
        return habRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("¡La habilidad no existe!"));
    }

    @Override
    public List<Habilidad> obtenerHabilidades(Long userId) {
        return habRepo.findByUserId(userId);
    }
}
