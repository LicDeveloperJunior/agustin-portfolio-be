package com.agustincollueque.portfolio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Agustin Collueque
 */
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {

    private String token;

    public LoginResponse(String tok) {
        this.token = tok;
    }
}
