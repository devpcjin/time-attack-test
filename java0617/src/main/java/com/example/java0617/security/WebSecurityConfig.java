package com.example.java0617.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class WebSecurityConfig {
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v2/member").permitAll()
                .anyRequest().authenticated()
                .and()
                . formLogin()
                .loginPage("/login")
                .permitAll();
    }
}
