package com.agustincollueque.portfolio.service;

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

    @Transactional
    @Override
    public Usuario crearUsuario(Usuario user) {
        return usuRepo.save(user);
    }

    @Transactional
    @Override
    public void eliminarUsuario(Usuario admin, Long id) {
        if (!esSuperAdmin(admin)) {
            throw new RuntimeException("El usuario no tiene los pemisos"); //Reemplazar por UnauthorizedUserException
        }
        usuRepo.deleteById(id);
    }

    @Transactional
    @Override
    public void modificarUsuario(Long userId, Usuario usu) {
        if (usuRepo.existsById(userId)) {
            throw new EntityNotFoundException("¡El usuario no existe! No se pudo modificar.");
        }
        usuRepo.save(usu);
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        Usuario user = usuRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("¡El usuario no existe!"));
        user.getListaFormacion().size();
        user.getListaHabilidad().size();
        user.getListaTrabajo().size();
        return user;
    }

    @Override
    public List<Usuario> obtenerUsuarios(Usuario admin) {
        if (!esSuperAdmin(admin)) {
            throw new RuntimeException("El usuario no tiene los pemisos"); //Reemplazar por UnauthorizedUserException
        }
        return usuRepo.findAll();
    }
    
    private boolean esSuperAdmin(Usuario admin) {
        return true; //Simula la verificacion de roles y/o permisos
    }
}
