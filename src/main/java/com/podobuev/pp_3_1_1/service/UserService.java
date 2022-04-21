package com.podobuev.pp_3_1_1.service;

import com.podobuev.pp_3_1_1.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(Long id);
    void edit(User user);
}
