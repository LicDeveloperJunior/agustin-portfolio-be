package com.agustincollueque.portfolio.security;

import com.agustincollueque.portfolio.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Agustin Collueque
 */
@Component
@RequiredArgsConstructor
public class SecurityUtils {

    public static Long getUserId() {
        return getUser().getId();
    }
    
    public static Usuario getUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
        return ((UserPrincipal) authentication.getPrincipal()).getUsuario();
    }
    return null;
}

}
