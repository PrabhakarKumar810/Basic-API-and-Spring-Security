package com.security.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeRequests()
               //One Way    .antMatchers(HttpMethod.GET,"/api/home","/api/login","/api/register").permitAll()
               .antMatchers("/api/public/**").hasRole("NORMAL")   //Its Only For NORMAL Access.
               .antMatchers("/api/users/**").hasRole("ADMIN")     //Its Only For NORMAL ADMIN.
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();



             //  .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Storing Username and Password.

        auth.inMemoryAuthentication().withUser("Prabhakar").password(passwordEncoder().encode("Prabhakar")).roles("NORMAL");
        auth.inMemoryAuthentication().withUser("Roshani").password(passwordEncoder().encode("Roshani")).roles("ADMIN");
    }


    //Creating Bean For PasswordEncoder
    @Bean
public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}
}
