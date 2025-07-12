package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.model.Formacion;
import com.agustincollueque.portfolio.service.IFormacionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formacion")
@RequiredArgsConstructor
public class FormacionController {

    private final IFormacionService servForm;

    @GetMapping("/")
    public List<Formacion> obtenerFormaciones() {
        return servForm.obtenerFormaciones();
    }

    @GetMapping("/{id}")
    public Formacion obtenerFormacion(@PathVariable("id") Long id) {
        return servForm.obtenerFormacion(id);
    }

    @PostMapping("/agregar")
    public void agregarFormacion(@RequestBody Formacion form) {
        servForm.crearFormacion(form);
    }

    @PostMapping("/editar")
    public void editarFormacion(@RequestBody Formacion form) {
        servForm.modificarFormacion(form);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarFormacion(@PathVariable("id") Long id) {
        servForm.eliminarFormacion(id);
    }
}
