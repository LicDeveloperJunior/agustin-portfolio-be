package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.exception.TrabajoNotFoundException;
import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.repository.TrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TrabajoService implements ITrabajoService{
    @Autowired
    TrabajoRepository trabRepo;
    
    @Override
    public void crearTrabajo(Trabajo trab) {
        trabRepo.save(trab);
    }

    @Override
    public void eliminarTrabajo(Long id) {
        trabRepo.deleteById(id);
    }

    @Override
    public Trabajo modificarTrabajo(Trabajo trab) {
        if (trabRepo.existsById(trab.getIdTrab())) {
            return trabRepo.save(trab);
        } else {
            throw new TrabajoNotFoundException("¡El trabajo no existe! No se pudo modificar.");
        }
    }

    @Override
    public Trabajo obtenerTrabajo(Long id) {
        return trabRepo.findById(id).orElseThrow(() -> new TrabajoNotFoundException("¡El trabajo no existe!"));
    }

    @Override
    public List<Trabajo> obtenerTrabajos() {
        return trabRepo.findAll();
    }
    
}
