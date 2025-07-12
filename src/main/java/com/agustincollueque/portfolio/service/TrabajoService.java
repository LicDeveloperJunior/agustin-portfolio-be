package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.repository.TrabajoRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TrabajoService implements ITrabajoService {

    private final TrabajoRepository trabRepo;

    @Transactional
    @Override
    public Trabajo crearTrabajo(Trabajo trab) {
        return trabRepo.save(trab);
    }

    @Transactional
    @Override
    public void eliminarTrabajo(Long id) {
        trabRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void modificarTrabajo(Trabajo trab) {
        if (trabRepo.existsById(trab.getIdTrab())) {
            throw new EntityNotFoundException("¡El trabajo no existe! No se pudo modificar.");
        }
        trabRepo.save(trab);
    }

    @Override
    public Trabajo obtenerTrabajo(Long id) {
        return trabRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("¡El trabajo no existe!"));
    }

    @Override
    public List<Trabajo> obtenerTrabajos() {
        return trabRepo.findAll();
    }

}
