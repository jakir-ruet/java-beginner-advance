package com.jakirbd.cors_csrf_backend_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @Column(
            name = "USERNAME",
            length = 128
    )
    private String username;

    @Column(
            name = "PASSWORD",
            length = 500,
            nullable = false
    )
    private String password;

    @Column(
            name = "ENABLED"
    )
    private String enabled;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    private List<Authority> authorities;
}