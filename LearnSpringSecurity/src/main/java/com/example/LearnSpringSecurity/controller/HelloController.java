package com.example.LearnSpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

//    @GetMapping("/")
    @GetMapping("")
    public String homePage(HttpServletRequest request) {
        return "Home Page\n"+"Session Id: "+request.getSession().getId();
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }
}
