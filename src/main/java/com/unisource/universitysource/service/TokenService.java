package com.unisource.universitysource.service;

import com.unisource.universitysource.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Scheduled(cron = "${purge.cron.expression}")
    public void purgeExpired() {
        Date now = Date.from(Instant.now());
        tokenRepository.deleteByExpiryDateLessThan(now);
    }
}
