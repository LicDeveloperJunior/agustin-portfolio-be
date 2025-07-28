package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.repository.FormacionRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FormacionService implements IFormacionService {
    
    private final FormacionRepository formRepo;
    
    @Transactional
    @Override
    public Formacion crearFormacion(Usuario usuario, Formacion form) {
        form.setUser(usuario);
        return formRepo.save(form);
    }
    
    @Transactional
    @Override
    public void eliminarFormacion(Long id) {
        formRepo.deleteById(id);
    }
    
    @Transactional
    @Override
    public void modificarFormacion(Long id, Formacion form) {
        Formacion formAux = formRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("¡La formacion no existe! No se puede modificar."));
        formAux.setStartDate(form.getStartDate());
        formAux.setEndDate(form.getEndDate());
        formAux.setDescription(form.getDescription());
        formAux.setAcademy(form.getAcademy());
        formAux.setTitle(form.getTitle());
        formAux.setType(form.getType());
        formRepo.save(form);
    }
    
    @Override
    public Formacion obtenerFormacion(Long id) {
        return formRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("¡La formacion no existe!"));
    }
    
    @Override
    public List<Formacion> obtenerFormaciones(Long userId) {
        return formRepo.findByUserId(userId);
    }
    
}
