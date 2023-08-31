package com.example.kotlinprojectserver.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.RequiredArgsConstructor;
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final ExService exService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
    }
}
