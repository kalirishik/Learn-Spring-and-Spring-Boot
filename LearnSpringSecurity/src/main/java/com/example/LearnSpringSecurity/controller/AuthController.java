package com.example.LearnSpringSecurity.controller;

import com.example.LearnSpringSecurity.model.Users2;
import com.example.LearnSpringSecurity.repository.UserRepository2;
import com.example.LearnSpringSecurity.service.UserService2;
import com.example.LearnSpringSecurity.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
//@RequiredArgsConstructor  -  used to all auto wired
public class AuthController {
    @Autowired // specific auto wired
    private UserService2 userService2;

    @Autowired
    private UserRepository2 userRepository2;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody Users2 user2){
        String emailId = user2.getEmailId();
        String password = passwordEncoder.encode(user2.getPassword());
        if(userRepository2.findByEmailId(emailId).isPresent()){
            return  new ResponseEntity<>("Email Already Exists", HttpStatus.UNAUTHORIZED);
        }
        userService2.addUser(Users2.builder().emailId(emailId).password(password).build());
        return new  ResponseEntity<>("User Data Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<?> LoginUser(@RequestBody Users2 user2){
        String emailId = user2.getEmailId();
        String password = user2.getPassword();

        Optional<Users2> users=userRepository2.findByEmailId(emailId);
        if(users.isEmpty()){
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }

        String dbPassword = users.get().getPassword();

        if(!passwordEncoder.matches(password,dbPassword)){
            return new ResponseEntity<>("Invalid User", HttpStatus.EXPECTATION_FAILED);
        }

        String token = jwtUtil.generateToken(emailId);
        return new ResponseEntity<>(Map.of("token",token), HttpStatus.OK);
    }



    @PostMapping("/addUser")
    public String addUser(@RequestBody Users2 user2) {
        return userService2.addUser(user2);
    }
    @GetMapping("/getAllUsers")
    public List<Users2> getUsers() {
        return userService2.getUsers();
    }
}