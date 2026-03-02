package com.example.LearnSpringSecurity.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import java.util.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(customizer -> customizer.disable()); // disable csrf and form
//        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
////        http.formLogin(Customizer.withDefaults()); // login form and login form with authenticate and authorization - browser
//        http.httpBasic(Customizer.withDefaults());// http request in api - support api testing
//        http.sessionManagement(session->
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // create different session id stateless
//        return http.build();

//        return http.csrf(customizer -> customizer.disable())
//        .authorizeHttpRequests(request->request.anyRequest().authenticated())
//        .httpBasic(Customizer.withDefaults())
//        .sessionManagement(session->
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();

        return http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request->
                        request.requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
                                .requestMatchers("/Student/**").hasAnyRole("ADMIN","STUDENT")
                                .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    // automatic users for login
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());// no password encode
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(4));
        return daoAuthenticationProvider;
    }

    // manula users for login
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1= User.withDefaultPasswordEncoder()
//                .username("rishi")
//                .password("456")
//                .build();
//
//        UserDetails user2= User.withDefaultPasswordEncoder()
//                .username("naresh")
//                .password("789")
//                .build();
//
//        UserDetails user3= User.withDefaultPasswordEncoder()
//                .username("mani")
//                .password("012")
//                .build();
//
////        return new InMemoryUserDetailsManager(user1,user2,user3);  //  varargs - User... users
//
//        List<UserDetails> users = new ArrayList<>();
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//        return new InMemoryUserDetailsManager(users);  // list of users - collection
//    }
}
