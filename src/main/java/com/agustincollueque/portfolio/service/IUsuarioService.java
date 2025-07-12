package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IUsuarioService {

    Usuario crearUsuario(Usuario usu);

    void eliminarUsuario(Long id);

    void modificarUsuario(Usuario usu);

    Usuario obtenerUsuario(Long id);

    List<Usuario> obtenerUsuarios();

    void agregarHabilidad(Long idUsuario, Habilidad hab);

    void agregarTrabajo(Long idUsuario, Trabajo trab);

    void agregarFormacion(Long idUsuario, Formacion form);
}
