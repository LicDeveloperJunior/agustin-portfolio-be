package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    public void crearUsuario(Usuario usu);
    public Usuario editarUsuario(Usuario usu);
    public void eliminarUsuario(Long id);
    public void modificarUsuario(Usuario usu);
    public Usuario obtenerUsuario(Long id);
    public List<Usuario> obtenerUsuarios();
    public boolean agregarHabilidad(Long idUsuario, Habilidad hab);
}
