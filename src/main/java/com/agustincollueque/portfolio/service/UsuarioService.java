package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.exception.UsuarioNotFoundException;
import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agustincollueque.portfolio.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioRepository usuRepo;

    @Override
    public void crearUsuario(Usuario user) {
        usuRepo.save(user);
    }
    
    @Override
    public Usuario editarUsuario(Usuario user) {
        return usuRepo.save(user);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuRepo.deleteById(id);
    }
    
    @Override
    public void modificarUsuario(Usuario usu) {
        if(usuRepo.existsById(usu.getId())) {
            usuRepo.save(usu);
        } else {
            throw new UsuarioNotFoundException("¡El usuario no existe! No se pudo modificar.");
        }
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuRepo.findById(id).orElseThrow(() -> new UsuarioNotFoundException("¡El usuario no existe!"));
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuRepo.findAll();
    }
    
    @Override
    public boolean agregarHabilidad(Long idUsuario, Habilidad hab) {
        boolean exito = false;
        if (this.usuRepo.existsById(idUsuario)) {
            this.usuRepo.findById(idUsuario).orElseThrow().getListaHabilidad().add(hab);
            exito = true;
        }
        return exito;
    }
}
