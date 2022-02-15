package com.parser.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UsedToken {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(columnDefinition = "TEXT")
    private String token;

    public UsedToken() {}

    public UsedToken(String token) {
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
