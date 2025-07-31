package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.SkillDto;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IHabilidadService {

    SkillDto crearHabilidad(Usuario usuario, SkillDto hab);

    void eliminarHabilidad(Long id);

    SkillDto modificarHabilidad(Long id, SkillDto hab);

    SkillDto obtenerHabilidad(Long id);

    List<SkillDto> obtenerHabilidades(Long userId);
}
