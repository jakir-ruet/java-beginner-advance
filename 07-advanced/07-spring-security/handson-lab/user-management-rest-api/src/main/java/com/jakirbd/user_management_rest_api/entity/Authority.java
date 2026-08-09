package com.jakirbd.user_management_rest_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUTHORITIES")
@Getter
@Setter
public class Authority {


    @EmbeddedId
    private AuthorityId id;


    @ManyToOne
    @MapsId("username")
    @JoinColumn(
            name = "USERNAME",
            referencedColumnName = "USERNAME"
    )
    private User user;


    // JPA requires default constructor
    public Authority() {
    }


    // Custom constructor
    public Authority(User user, String authority) {

        this.user = user;

        this.id = new AuthorityId();
        this.id.setUsername(user.getUsername());
        this.id.setAuthority(authority);
    }

}