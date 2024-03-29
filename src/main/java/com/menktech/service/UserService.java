package com.menktech.service;

import com.menktech.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
}
