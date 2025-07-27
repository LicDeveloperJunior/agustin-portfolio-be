package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.dto.ContactDto;
import com.agustincollueque.portfolio.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Agustin Collueque
 */
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<?> enviarMensaje(@RequestBody ContactDto contacto) {
        try {
            emailService.sendEmail(contacto.getName(), contacto.getEmail(), contacto.getMessage());
            return ResponseEntity.ok("Mensaje enviado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar mensaje");
        }
    }
}

