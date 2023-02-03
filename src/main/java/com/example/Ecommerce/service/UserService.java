package com.example.Ecommerce.service;

import com.example.Ecommerce.Models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    List<User> findAllUsers();

    User editUser(User user, long id);

    User findUserById(long id);

    void deleteUser(long id);

    User findByUsername(String name);
}
