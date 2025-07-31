package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.dto.SkillDto;
import com.agustincollueque.portfolio.security.SecurityUtils;
import com.agustincollueque.portfolio.service.IHabilidadService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/habilidades")
@RequiredArgsConstructor
public class HabilidadController {
    private final IHabilidadService servHab;
    private final SecurityUtils securityUtils;

    @GetMapping("/{id}")
    @ResponseBody
    public SkillDto obtenerHabilidad(@PathVariable("id") Long id) {
        return servHab.obtenerHabilidad(id);
    }

    @GetMapping
    @ResponseBody
    public List<SkillDto> obtenerHabilidades() {
        return servHab.obtenerHabilidades(securityUtils.getUserId());
    }

    @PostMapping
    public SkillDto agregarHabilidad(@RequestBody SkillDto hab) {
        return servHab.crearHabilidad(securityUtils.getUser(), hab);
    }
    
    @PutMapping("/{id}")
    public SkillDto editarHabilidad(@PathVariable Long id, @RequestBody SkillDto hab) {
        return servHab.modificarHabilidad(id, hab);
    }

    @DeleteMapping("/{id}")
    public void eliminarHabilidad(@PathVariable("id") Long id) {
        servHab.eliminarHabilidad(id);
    }
}
