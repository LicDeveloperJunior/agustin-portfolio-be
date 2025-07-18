package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.security.SecurityUtils;
import com.agustincollueque.portfolio.service.IFormacionService;
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
@RequestMapping("/formaciones")
@RequiredArgsConstructor
public class FormacionController {

    private final IFormacionService servForm;
    private final SecurityUtils securityUtils;

    @GetMapping
    @ResponseBody
    public List<Formacion> obtenerFormaciones() {
        return servForm.obtenerFormaciones(securityUtils.getUserId());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Formacion obtenerFormacion(@PathVariable("id") Long id) {
        return servForm.obtenerFormacion(id);
    }

    @PostMapping
    public void crearFormacion(@RequestBody Formacion form) {
        servForm.crearFormacion(securityUtils.getUser(), form);
    }

    @PutMapping("/{id}")
    public void editarFormacion(@PathVariable Long id, @RequestBody Formacion form) {
        servForm.modificarFormacion(id, form);
    }

    @DeleteMapping("/{id}")
    public void eliminarFormacion(@PathVariable("id") Long id) {
        servForm.eliminarFormacion(id);
    }
}
