package com.jakirbd.cors_csrf_backend_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AUTHORITIES")
@Data

public class Authority {

    @EmbeddedId
    private AuthorityId id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(
            name = "USERNAME"
    )
    private User user;
}