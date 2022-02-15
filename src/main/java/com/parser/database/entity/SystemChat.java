package com.parser.database.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "chat")
public class SystemChat {
    @Id
    @Column
    @Type(type = "pg-uuid")
    private UUID id = UUID.randomUUID();

    private Long chatId;

    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(columnDefinition = "TIMESTAMP")
    private Instant registerDate;

    @Column(columnDefinition = "TIMESTAMP")
    private Instant expiresDate;

    public SystemChat() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Instant registerDate) {
        this.registerDate = registerDate;
    }

    public Instant getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Instant expiresDate) {
        this.expiresDate = expiresDate;
    }
}
