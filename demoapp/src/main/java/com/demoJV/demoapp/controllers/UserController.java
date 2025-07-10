package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Users;
import com.demoJV.demoapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<Users> getAllUser(){
        System.out.println("get User");
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public Users saveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }

    @PutMapping("/user/{id}")
    public Users editUser(@PathVariable("id") int id,@RequestBody Users user){
        return  userService.editUser(id,user);

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "Delete Success";
    }
}
