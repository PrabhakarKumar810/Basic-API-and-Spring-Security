package com.security.springbootsecurity.Services;

import com.security.springbootsecurity.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list=new ArrayList<>();

    public UserService(){
        list.add(new User("abc","abcd","abc@gmail.com"));
        list.add(new User("amit","amit1","am@gmail.com"));
    }


    //Get All user.
    public List<User> getAllUsers(){
        return this.list;
    }

    //Get User By UserName.
    public User usergetUser(String username){
        return this.list.stream().filter((user -> user.getUsername().equals(username))).findAny().get();
    }


    //Add User Details.
    public User addUser(User user){
        this.list.add(user);
        return user;
    }
}
