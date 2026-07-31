package com.jakirbd.cors_csrf_backend_app.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data

public class AuthorityId implements Serializable {

    private String username;
    private String authority;
}