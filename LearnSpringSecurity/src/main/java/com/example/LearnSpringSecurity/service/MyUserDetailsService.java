package com.example.LearnSpringSecurity.service;

import com.example.LearnSpringSecurity.model.UserPrinciple;
import com.example.LearnSpringSecurity.model.Users;
import com.example.LearnSpringSecurity.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrinciple(user);
    }
}
