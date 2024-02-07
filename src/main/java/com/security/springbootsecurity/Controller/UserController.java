package com.security.springbootsecurity.Controller;

import com.security.springbootsecurity.Models.User;
import com.security.springbootsecurity.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;



    //All users
    //http://localhost:8080/api/users/getAll

    @PreAuthorize("hasRole('ADMIN')") //Only ADMIN Can Access This Method Not AnyOne
    @GetMapping("/getAll")
    public List<User> getAllUser(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }


    //Return Single User
    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        User user = userService.usergetUser(username);
        return user;
    }

    //Add User
    //http://localhost:8080/api/users/create
    @PostMapping("/create")
    public User addUser(@RequestBody User user){
        User user1 = userService.addUser(user);
        return user1;
    }
}
