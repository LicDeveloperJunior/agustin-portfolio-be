package com.agustincollueque.portfolio.controller;

import com.agustincollueque.portfolio.dto.ContactDto;
import com.agustincollueque.portfolio.service.EmailService;
import com.agustincollueque.portfolio.service.RateLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Agustin Collueque
 */
@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final EmailService emailService;
    private final RateLimitService limitService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody ContactDto contacto, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        if (!limitService.canSend(ip)) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body(Map.of("error", "You have exceeded the hourly shipping limit"));
        }
        try {
            emailService.sendEmail(contacto.getName(), contacto.getEmail(), contacto.getMessage());
            return ResponseEntity.ok(Map.of("message", "Message send successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Error al enviar mensaje"));
        }
    }
}
