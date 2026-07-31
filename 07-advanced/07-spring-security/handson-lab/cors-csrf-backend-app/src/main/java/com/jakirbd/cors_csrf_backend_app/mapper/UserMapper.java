package com.jakirbd.cors_csrf_backend_app.mapper;


import com.jakirbd.cors_csrf_backend_app.dto.AuthorityDto;
import com.jakirbd.cors_csrf_backend_app.dto.UserDto;

import com.jakirbd.cors_csrf_backend_app.entity.User;

import org.springframework.stereotype.Component;


import java.util.stream.Collectors;



@Component
public class UserMapper {



    public UserDto toDto(User user){


        UserDto dto = new UserDto();


        dto.setUsername(
                user.getUsername()
        );


        dto.setEnabled(
                user.getEnabled()
        );


        dto.setAuthorities(
                user.getAuthorities()
                        .stream()
                        .map(authority -> {

                            AuthorityDto authorityDto =
                                    new AuthorityDto();

                            authorityDto.setAuthority(
                                    authority.getId()
                                            .getAuthority()
                            );

                            return authorityDto;

                        })
                        .collect(Collectors.toList())
        );


        return dto;
    }

}