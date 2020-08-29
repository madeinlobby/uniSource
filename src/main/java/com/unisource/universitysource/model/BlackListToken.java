package com.unisource.universitysource.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "black_list_token")
public class BlackListToken {
    @Id
    @Column(name = "jwt", nullable = false, unique = true)
    private String jwt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    public BlackListToken() {
    }

    public BlackListToken(String jwt, Date expirationDate) {
        this.jwt = jwt;
        this.expirationDate = expirationDate;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
