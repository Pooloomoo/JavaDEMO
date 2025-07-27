package com.demoJV.demoapp.controllers;

import com.demoJV.demoapp.exception.UserNotFoundException;
import com.demoJV.demoapp.models.Users;
import com.demoJV.demoapp.models.auth.AuthDTO;
import com.demoJV.demoapp.security.JwtGenerateToken;
import com.demoJV.demoapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtGenerateToken jwtGenerateToken;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Users> getAllUser(){
        System.out.println("get User");
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable("id") int id){
        Users user = userService.getUser(id);
        if(user == null){
            throw new UserNotFoundException("id:"+id);
        }
        return user;
    }

    @PostMapping("/")
    public Users saveUser(@Valid @RequestBody Users user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public Users editUser(@PathVariable("id") int id,@RequestBody Users user){
        return  userService.editUser(id,user);

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "Delete Success";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users){
        if(!userService.isEmailExist(users.email)){
            return new ResponseEntity<>("Sorry user has been take",HttpStatus.BAD_REQUEST);
        }
        Users regisUser = new Users();
        regisUser.name = users.name;
        regisUser.email = users.email;
        regisUser.password = passwordEncoder.encode(users.password);
        regisUser.role = "USER";
        userService.saveUser(regisUser);
        return new ResponseEntity<>("Register Complete",HttpStatus.OK);
    }

//    @PostMapping("/user/login")
//    public ResponseEntity<String> login(@RequestBody Users users){
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                users.email,
//                users.password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("Login Success!!",HttpStatus.OK);
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody Users users){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                users.email,
                users.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerateToken.generateToken(authentication);
        return new ResponseEntity<>(new AuthDTO(token),HttpStatus.OK);
    }

}
