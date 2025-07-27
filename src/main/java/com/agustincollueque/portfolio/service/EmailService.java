package com.agustincollueque.portfolio.service;

import com.agustincollueque.portfolio.configuration.ResendEnvConfig;
import java.io.IOException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Collueque
 */
@Service
public class EmailService implements IEmailService {
    private final ResendEnvConfig config;
    
    public EmailService(ResendEnvConfig config) {
        this.config = config;
    }

    @Override
    public void sendEmail(String name, String email, String message) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost("https://api.resend.com/emails");
            post.setHeader("Authorization", "Bearer " + config.getApiKey());
            post.setHeader("Content-Type", "application/json");

            String cuerpo = """
            {
              "from": "%s",
              "to": ["%s"],
              "subject": "Nuevo mensaje de contacto",
              "html": "<p><strong>Nombre:</strong> %s</p><p><strong>Email:</strong> %s</p><p><strong>Mensaje:</strong><br/>%s</p>"
            }
            """.formatted(config.getFrom(), config.getTo(), name, email, message);

            post.setEntity(new StringEntity(cuerpo, ContentType.APPLICATION_JSON, false));
            httpClient.execute(post);
        }
    }
}

