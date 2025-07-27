package com.agustincollueque.portfolio.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Agustin Collueque
 */
@Service
public class RateLimitService {

    private final Map<String, List<LocalDateTime>> ipAttempts = new ConcurrentHashMap<>();

    private static final int ATTEMPTS_MAX = 2;
    private static final Duration INTERVAL = Duration.ofHours(1);

    public boolean canSend(String ip) {
        LocalDateTime now = LocalDateTime.now();

        List<LocalDateTime> attempts = ipAttempts.getOrDefault(ip, new ArrayList<>());

        attempts = attempts.stream()
                .filter(t -> Duration.between(t, now).compareTo(INTERVAL) < 0)
                .collect(Collectors.toList());

        if (attempts.size() >= ATTEMPTS_MAX) {
            return false;
        }

        attempts.add(now);
        ipAttempts.put(ip, attempts);
        return true;
    }
}

