package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
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
    public Formacion crearFormacion(Formacion form) {
        return formRepo.save(form);
    }

    @Transactional
    @Override
    public void eliminarFormacion(Long id) {
        formRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void modificarFormacion(Formacion form) {
        if (!formRepo.existsById(form.getIdForm())) {
            throw new EntityNotFoundException("¡La formacion no existe! No se puede modificar.");
        }
        formRepo.save(form);
    }

    @Override
    public Formacion obtenerFormacion(Long id) {
        return formRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("¡La formacion no existe!"));
    }

    @Override
    public List<Formacion> obtenerFormaciones() {
        return formRepo.findAll();
    }

}
