package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.repository.FormacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agustincollueque.portfolio.exception.FormacionNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormacionService implements IFormacionService{
    @Autowired
    FormacionRepository formRepo;
    
    @Override
    public void crearFormacion(Formacion form) {
        formRepo.save(form);
    }

    @Override
    public void eliminarFormacion(Long id) {
        formRepo.deleteById(id);
    }

    @Override
    public Formacion modificarFormacion(Formacion form) {
        if (formRepo.existsById(form.getIdForm())){
            return formRepo.save(form);
        } 
        throw new FormacionNotFoundException("¡La formacion no existe! No se puede modificar.");
    }

    @Override
    public Formacion obtenerFormacion(Long id) {
        return formRepo.findById(id).orElseThrow(() -> new FormacionNotFoundException("¡La formacion no existe!"));
    }

    @Override
    public List<Formacion> obtenerFormaciones() {
        return formRepo.findAll();
    }
    
}
