package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.models.Users;
import com.demoJV.demoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody Users users){
        if(userService.isUserExist(users.email)){
            return new ResponseEntity<>("Sorry user has been take",HttpStatus.BAD_REQUEST);
        }
        Users regisUser = new Users();
        regisUser.email = users.email;
        regisUser.password = passwordEncoder.encode(users.password);
        regisUser.role = "USER";
        userService.saveUser(regisUser);
        return new ResponseEntity<>("Register Complete",HttpStatus.OK);
    }
}
