package com.example.FirstAPI.controller;

import com.example.FirstAPI.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/")
    public String greet(){
        return helloService.greedy();
    }

//    @GetMapping("/")
//    public String greet(){
//        System.out.println("Hello World");
//        return "hello";
//    }

//    @GetMapping("/about")
//    public String about(){
//        return "about page";
//    }
}
