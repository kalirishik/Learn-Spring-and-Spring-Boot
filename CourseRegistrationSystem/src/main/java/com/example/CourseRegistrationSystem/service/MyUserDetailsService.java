package com.example.CourseRegistrationSystem.service;

import com.example.CourseRegistrationSystem.model.UserPrinciple;
import com.example.CourseRegistrationSystem.model.Users;
import com.example.CourseRegistrationSystem.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
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
