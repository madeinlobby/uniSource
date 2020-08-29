package com.unisource.universitysource.controller;

import com.unisource.universitysource.model.BlackListToken;
import com.unisource.universitysource.repository.BlackListTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AppEventHandler {
    @Autowired
    private BlackListTokenRepository blackListTokenRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void deleteExpiredTokens() {
        List<BlackListToken> tokens = blackListTokenRepository.findAll();
        tokens.forEach(blackListToken -> {
            if (blackListToken.getExpirationDate().before(new Date()))
                blackListTokenRepository.delete(blackListToken);
        });
        System.out.println("expired tokens deleted.");
    }
}
