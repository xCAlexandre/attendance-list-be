package com.sportsmatch.backend.services;

import java.util.ArrayList;
import java.util.List;

import com.sportsmatch.backend.model.User;
import com.sportsmatch.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
