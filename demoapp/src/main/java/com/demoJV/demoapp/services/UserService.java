package com.demoJV.demoapp.services;

import com.demoJV.demoapp.models.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUser();
    Users getUser(int id);
    Users saveUser(Users user);
    Users editUser(int id,Users user);
    void deleteUser(int id);
}
