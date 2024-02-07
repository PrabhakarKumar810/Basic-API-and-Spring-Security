package com.security.springbootsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class HomeController {


    //http://localhost:8080/api/public/home
    @GetMapping("/home")
    public String home(){
        return "This Is Home Page";
    }

    //http://localhost:8080/api/public/login
    @GetMapping("/login")
    public String login(){
        return "This Is Login Page";
    }

    //http://localhost:8080/api/public/register
    @GetMapping("/register")
    public String register(){
        return "This Is Register Page";
    }
}
