package com.security.springbootsecurity.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestClass1 {

    public static void main(String[] args) {
        String x="PPP";

        //Here We Encoding The Text.
       PasswordEncoder passwordEncoder1=new BCryptPasswordEncoder();
        String encode = passwordEncoder1.encode(x);
        System.out.println("ECoded:"+encode);
    }
}
