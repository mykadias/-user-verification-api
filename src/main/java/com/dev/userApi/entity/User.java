package com.dev.userApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;


import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;
    private boolean emailVerified;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }
}
