package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;
import com.agustincollueque.portfolio.repository.UsuarioRepository;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuRepo;
    private final HabilidadService habServ;
    private final TrabajoService trabServ;
    private final FormacionService formServ;

    @Transactional
    @Override
    public Usuario crearUsuario(Usuario user) {
        return usuRepo.save(user);
    }

    @Transactional
    @Override
    public void eliminarUsuario(Long id) {
        usuRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void modificarUsuario(Usuario usu) {
        if (usuRepo.existsById(usu.getId())) {
            throw new EntityNotFoundException("¡El usuario no existe! No se pudo modificar.");
        }
        usuRepo.save(usu);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("¡El usuario no existe!"));
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuRepo.findAll();
    }

    @Transactional
    @Override
    public void agregarHabilidad(Long idUsuario, Habilidad hab) {
        this.usuRepo.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("¡El usuario no existe!"))
                .getListaHabilidad().add(habServ.crearHabilidad(hab));
    }

    @Transactional
    @Override
    public void agregarTrabajo(Long idUsuario, Trabajo trab) {
        this.usuRepo.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("¡El usuario no existe!"))
                .getListaTrabajo().add(trabServ.crearTrabajo(trab));
    }

    @Transactional
    @Override
    public void agregarFormacion(Long idUsuario, Formacion form) {
        this.usuRepo.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException("¡El usuario no existe!"))
                .getListaFormacion().add(formServ.crearFormacion(form));
    }
}
