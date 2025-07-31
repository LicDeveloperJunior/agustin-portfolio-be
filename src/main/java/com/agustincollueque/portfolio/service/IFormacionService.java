package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.dto.FormationDto;
import com.agustincollueque.portfolio.model.Usuario;
import java.util.List;

public interface IFormacionService {

    FormationDto crearFormacion(Usuario usuario, FormationDto form);

    void eliminarFormacion(Long id);

    FormationDto modificarFormacion(Long id, FormationDto form);

    FormationDto obtenerFormacion(Long id);

    List<FormationDto> obtenerFormaciones(Long userId);
}
