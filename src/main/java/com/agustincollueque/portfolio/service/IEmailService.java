package com.agustincollueque.portfolio.service;

import java.io.IOException;

/**
 *
 * @author Agustin Collueque
 */
public interface IEmailService {
    void sendEmail(String name, String email, String message) throws IOException;
}
