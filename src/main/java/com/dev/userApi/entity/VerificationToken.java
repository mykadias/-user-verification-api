package com.dev.userApi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String token;
    private LocalDateTime expiryDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationToken(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.expiryDate = LocalDateTime.now().plusMinutes(15);
    }

    public VerificationToken() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
