package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Proyecto;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.ProyectoRepository;
import java.util.List;
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

    @Transactional
    @Override
    public Proyecto crearProyecto(Usuario usuario, Proyecto proy) {
        proy.setUser(usuario);
        return proyRepo.save(proy);
    }    

    @Override
    public void eliminarProyecto(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public void modificarProyecto(Long id, Proyecto proy) {
        Proyecto projAux = proyRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("¡El proyecto no existe!"));
        projAux.setStartDate(proy.getStartDate());
        projAux.setEndDate(proy.getEndDate());
        projAux.setLink(proy.getLink());
        projAux.setTitle(proy.getTitle());
        projAux.setUrlImg(proy.getUrlImg());
        projAux.setDescription(proy.getDescription());
        proyRepo.save(proy);
    }
    
    @Override
    public List<Proyecto> obtenerProyectos(Long userId) {
        return proyRepo.findByUserId(userId);
    }

    @Override
    public Proyecto obtenerProyecto(Long id) {
        return proyRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("El proyecto no existe"));
    }
}
