package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.dto.JobDto;
import com.agustincollueque.portfolio.security.SecurityUtils;
import com.agustincollueque.portfolio.service.ITrabajoService;
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
@RequestMapping("/trabajos")
@RequiredArgsConstructor
public class TrabajoController {

    private final ITrabajoService servTrab;
    private final SecurityUtils securityUtils;

    @GetMapping
    @ResponseBody
    public List<JobDto> obtenerTrabajos() {
        return servTrab.obtenerTrabajos(securityUtils.getUserId());
    }

    @GetMapping("/{id}")
    public JobDto obtenerTrabajo(@PathVariable("id") Long id) {
        return servTrab.obtenerTrabajo(id);
    }

    @PostMapping
    public JobDto agregarTrabajo(@RequestBody JobDto trab) {
        return servTrab.crearTrabajo(securityUtils.getUser(), trab);
    }

    @PutMapping("/{id}")
    public JobDto editarTrabajo(@PathVariable Long id, @RequestBody JobDto trab) {
        return servTrab.modificarTrabajo(id, trab);
    }

    @DeleteMapping("/{id}")
    public void eliminarTrabajo(@PathVariable("id") Long id) {
        servTrab.eliminarTrabajo(id);
    }
}
