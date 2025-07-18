package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.security.SecurityUtils;
import com.agustincollueque.portfolio.service.IUsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final IUsuarioService servUsu;
    private final SecurityUtils securityUtils;

    @GetMapping("/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return servUsu.obtenerUsuario(id);
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return servUsu.obtenerUsuarios(securityUtils.getUser());
    }

    @PostMapping
    public void agregarUsuario(@RequestBody Usuario usu) {
        servUsu.crearUsuario(usu);
    }

    @PutMapping
    public void editarUsuario(@RequestBody Usuario usu) {
        servUsu.modificarUsuario(securityUtils.getUserId(), usu);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        servUsu.eliminarUsuario(securityUtils.getUser(), id);
    }
}
