package com.example.demo.service;


import com.example.demo.exception.UserNotFoundException;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1L, "Ali", "ali@gmail.com"));
        users.add(new User(2L, "Vali", "vali@gmail.com"));
        users.add(new User(3L, "Murad", "murad@gmail.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {

        if (id <= 0) {
            throw new IllegalArgumentException("user id must be greater than 0");
        }

        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        throw new UserNotFoundException("User with id " + id + " not found");
    }
}