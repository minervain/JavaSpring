package com.qqq.qqq.service;

import com.qqq.qqq.model.Users;

import java.util.List;

public interface UserService {
    String getUserMessage();

    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users createUser(Users user);

    Users updateUser(Long id, Users user);

    void deleteUser(Long id);
}
