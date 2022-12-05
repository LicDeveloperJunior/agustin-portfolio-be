package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.service.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
    @Autowired
    private IHabilidadService servHab;

    @GetMapping("/{id}")
    @ResponseBody
    public Habilidad obtenerHabilidad(@PathVariable("id") Long id) {
        return servHab.obtenerHabilidad(id);
    }

    @GetMapping("/")
    public List<Habilidad> obtenerHabilidades() {
        return servHab.obtenerHabilidades();
    }

    @PostMapping("/agregar")
    public void agregarHabilidad(@RequestBody Habilidad hab) {
        servHab.crearHabilidad(hab);
    }
    
    @PostMapping("/agregar/{idUsuario}")
    public void agregarHabilidad(@RequestBody Habilidad hab, @PathVariable("idUsuario") Long idUsuario) {
       servHab.crearHabilidad(hab, idUsuario);
    }
    
    @PostMapping("/editar")
    public Habilidad editarHabilidad(@RequestBody Habilidad hab) {
        return servHab.modificarHabilidad(hab);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarHabilidad(@PathVariable("id") Long id) {
        servHab.eliminarHabilidad(id);
    }
}
