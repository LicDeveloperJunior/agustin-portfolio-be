package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.service.IUsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final IUsuarioService servUsu;
       
    @GetMapping("/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return servUsu.obtenerUsuario(id);
    }
    
    @PostMapping("/agregar")
    public void agregarUsuario(@RequestBody Usuario usu) {
        servUsu.crearUsuario(usu);
    }
    
    @PutMapping("/actualizar")
    public void editarUsuario(@RequestBody Usuario usu) {
        servUsu.modificarUsuario(usu);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        servUsu.eliminarUsuario(id);
    }
    
    @GetMapping("/")
    public List<Usuario> verUsuarios() {
        return servUsu.obtenerUsuarios();
    }
}
