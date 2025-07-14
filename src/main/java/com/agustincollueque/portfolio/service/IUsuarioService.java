package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IUsuarioService {

    Usuario crearUsuario(Usuario usu);

    void eliminarUsuario(Usuario admin, Long id);

    void modificarUsuario(Long userId, Usuario usu);

    Usuario obtenerUsuario(Long id);

    List<Usuario> obtenerUsuarios(Usuario user);
}
