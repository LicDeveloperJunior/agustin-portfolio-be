package com.agustincollueque.portfolio.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

/**
 *
 * @author Agustin Collueque
 */

@Component
public class ResendEnvConfig {

    private final Dotenv dotenv;

    public ResendEnvConfig() {
        dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();
    }

    public String getApiKey() {
        return dotenv.get("RESEND_API_KEY");
    }

    public String getFrom() {
        return dotenv.get("RESEND_FROM");
    }

    public String getTo() {
        return dotenv.get("RESEND_TO");
    }
}

