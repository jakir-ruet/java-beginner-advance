package com.jakirbd.cors_csrf_backend_app.service;


import com.jakirbd.cors_csrf_backend_app.entity.User;
import com.jakirbd.cors_csrf_backend_app.repository.UserRepository;


import org.springframework.stereotype.Service;


import java.util.Optional;



@Service
public class UserServiceImpl
        implements UserService {


    private final UserRepository userRepository;



    public UserServiceImpl(
            UserRepository userRepository) {

        this.userRepository = userRepository;

    }



    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }



    @Override
    public User save(User user) {


        return userRepository.save(user);

    }



    @Override
    public void deleteByUsername(
            String username) {


        userRepository.deleteById(username);

    }

}