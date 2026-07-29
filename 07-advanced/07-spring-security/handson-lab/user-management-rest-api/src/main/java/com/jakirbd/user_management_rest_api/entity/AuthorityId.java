package com.jakirbd.user_management_rest_api.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
public class AuthorityId implements Serializable {


    private String username;


    private String authority;

}