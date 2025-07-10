package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.models.Users;
import com.demoJV.demoapp.repositories.UserRepository;
import com.demoJV.demoapp.services.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public Users getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users saveUser(Users user){
        return userRepository.save(user);
    }

    @Override
    public Users editUser(int id,Users user){
        Users oldUser = userRepository.findById(id).orElse(null);
        if (oldUser != null) {
            oldUser.name = user.name;
            oldUser.email = user.email;
            oldUser.role = user.role;
            if (user.customer != null && user.customer.id > 0) {
                oldUser.customer = user.customer;
            }
            return userRepository.save(oldUser);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    @Override
    public boolean isEmailExist(String email){
        return userRepository.findByEmail(email).isEmpty();
    }
}
