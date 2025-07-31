package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.dto.LoginDto;
import com.agustincollueque.portfolio.dto.LoginResponse;
import com.agustincollueque.portfolio.security.JwtUtil;
import com.agustincollueque.portfolio.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agustin Collueque
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request) {
        System.out.println("Entre al login -> " + request.getEmail() + " - " + request.getPassword());
        try {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            System.out.println("USER DETAIL -> "+userDetails.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            System.out.println(jwt);
            return ResponseEntity.ok(new LoginResponse(jwt));
        } catch (Exception e) {
            System.out.println("ERROR -> "+e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
