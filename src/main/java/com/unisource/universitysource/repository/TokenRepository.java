package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Token;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface TokenRepository extends CrudRepository<Token, Long> {
    @Modifying
    @Query("delete from token t where t.expiry_time <= ?1")
    void deleteByExpiryDateLessThan(Date now);
}
