package com.jakirbd.user_management_rest_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "USERNAME", length = 128)
    private String username;


    @Column(name = "PASSWORD", nullable = false, length = 500)
    private String password;


    @Column(name = "ENABLED", length = 1)
    private String enabled;


    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Authority> authorities;

}