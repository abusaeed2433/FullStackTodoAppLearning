package com.lazymind.full_stack_todo_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfig {

    // filter chain
    // authenticate all request by default
    // disabling csrf
    // stateless rest api

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        /*
        1. Response to preflight request doesn't pass access control check <- OPTION requests
        2. Basic auth
        */
        security
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // 1
                                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // basic auth. Shows a popup in browser when api request is made
                .sessionManagement( session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(AbstractHttpConfigurer::disable);

        return security.build();
    }

}
