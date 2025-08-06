package com.agustincollueque.portfolio.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Agustin Collueque
 */

@Component
public class ResendEnvConfig {

    @Value("${resend.api.key}")
    private String apiKey;

    @Value("${resend.from}")
    private String from;

    @Value("${resend.to}")
    private String to;

    public String getApiKey() {
        return apiKey;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}

