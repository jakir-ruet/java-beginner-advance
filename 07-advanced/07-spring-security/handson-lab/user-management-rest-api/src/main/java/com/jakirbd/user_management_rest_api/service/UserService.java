package com.jakirbd.user_management_rest_api.service;

import com.jakirbd.user_management_rest_api.dto.UserRequest;
import com.jakirbd.user_management_rest_api.dto.UserResponse;
import com.jakirbd.user_management_rest_api.entity.Authority;
import com.jakirbd.user_management_rest_api.entity.User;
import com.jakirbd.user_management_rest_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository repository;
    private final PasswordEncoder encoder;


    public UserService(
            UserRepository repository,
            PasswordEncoder encoder) {

        this.repository = repository;
        this.encoder = encoder;
    }



    public User create(UserRequest request) {

        User user = new User();

        user.setUsername(request.username());

        user.setPassword(
                encoder.encode(request.password())
        );

        user.setEnabled("Y");

        Authority authority =
                new Authority(
                        user,
                        request.authority()
                );

        user.getAuthorities()
                .add(authority);

        return repository.save(user);
    }

    public List<UserResponse> findAll(){

        return repository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getUsername(),
                        user.getEnabled(),
                        user.getAuthorities()
                                .stream()
                                .map(a -> a.getId().getAuthority())
                                .toList()
                ))
                .toList();
    }
}
