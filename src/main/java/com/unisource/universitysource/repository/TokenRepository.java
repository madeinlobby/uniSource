package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface TokenRepository extends CrudRepository<Token, Long> {
    void deleteByExpiryDateLessThan(Date now);
}
