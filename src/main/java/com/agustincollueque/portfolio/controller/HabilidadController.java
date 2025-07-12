package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Habilidad;
import com.agustincollueque.portfolio.service.IHabilidadService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidad")
@RequiredArgsConstructor
public class HabilidadController {
    private final IHabilidadService servHab;

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
    
    @PostMapping("/editar")
    public void editarHabilidad(@RequestBody Habilidad hab) {
        servHab.modificarHabilidad(hab);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarHabilidad(@PathVariable("id") Long id) {
        servHab.eliminarHabilidad(id);
    }
}
