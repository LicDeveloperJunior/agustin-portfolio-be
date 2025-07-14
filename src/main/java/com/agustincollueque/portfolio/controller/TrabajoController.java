package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Trabajo;
import com.agustincollueque.portfolio.security.SecurityUtils;
import com.agustincollueque.portfolio.service.ITrabajoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trabajos")
@RequiredArgsConstructor
public class TrabajoController {

    private final ITrabajoService servTrab;
    private final SecurityUtils securityUtils;

    @GetMapping
    public List<Trabajo> obtenerTrabajos() {
        return servTrab.obtenerTrabajos(securityUtils.getUserId());
    }

    @GetMapping("/{id}")
    public Trabajo obtenerTrabajo(@PathVariable("id") Long id) {
        return servTrab.obtenerTrabajo(id);
    }

    @PostMapping
    public void agregarTrabajo(@RequestBody Trabajo trab) {
        servTrab.crearTrabajo(securityUtils.getUser(), trab);
    }

    @PutMapping("/{id}")
    public void editarTrabajo(@PathVariable Long id, @RequestBody Trabajo trab) {
        servTrab.modificarTrabajo(id, trab);
    }

    @DeleteMapping("/{id}")
    public void eliminarTrabajo(@PathVariable("id") Long id) {
        servTrab.eliminarTrabajo(id);
    }
}
