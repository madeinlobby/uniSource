package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.BlackListToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListTokenRepository extends JpaRepository<BlackListToken, String> {
    Boolean existsByJwt(String jwt);
}
