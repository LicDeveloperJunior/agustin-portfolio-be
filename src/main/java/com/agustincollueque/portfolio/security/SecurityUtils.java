package com.agustincollueque.portfolio.security;

import com.agustincollueque.portfolio.model.Usuario;
import com.agustincollueque.portfolio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Agustin Collueque
 */
@Component
@RequiredArgsConstructor
public class SecurityUtils {

    private final UsuarioService usuarioService;

    public Long getUserId() {
        //Simula la obtencion del ID del contexto actual (aún no implementado con Spring Security)
        return 1L;
    }
    
    public Usuario getUser() {
        //Simula la obtención del Usuario en el contexto actual (aún no implementado con Spring Security)
        return new Usuario();
    }
}
