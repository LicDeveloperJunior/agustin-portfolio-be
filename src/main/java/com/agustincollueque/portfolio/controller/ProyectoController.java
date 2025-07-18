package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Proyecto;
import com.agustincollueque.portfolio.security.SecurityUtils;
import com.agustincollueque.portfolio.service.IProyectoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agustin Collueque
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/proyectos")
@RequiredArgsConstructor
public class ProyectoController {

    private final IProyectoService servProy;
    private final SecurityUtils securityUtils;

    @GetMapping("/{id}")
    @ResponseBody
    public Proyecto obtenerProyecto(@PathVariable("id") Long id) {
        return servProy.obtenerProyecto(id);
    }
    
    @GetMapping
    @ResponseBody
    public List<Proyecto> obtenerProyectos() {
        return servProy.obtenerProyectos(securityUtils.getUserId());
    }

    @PostMapping
    public void agregarProyecto(@RequestBody Proyecto proy) {
        servProy.crearProyecto(securityUtils.getUser(), proy);
    }

    @PostMapping("/{id}")
    public void editarProyecto(@PathVariable Long id, @RequestBody Proyecto proy) {
        servProy.modificarProyecto(id, proy);
    }

    @DeleteMapping("/{id}")
    public void eliminarProyecto(@PathVariable("id") Long id) {
        servProy.eliminarProyecto(id);
    }
}
