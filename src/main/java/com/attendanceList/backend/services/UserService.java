package com.attendanceList.backend.services;

import java.util.ArrayList;
import java.util.List;

import com.attendanceList.backend.model.user.User;
import com.attendanceList.backend.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
