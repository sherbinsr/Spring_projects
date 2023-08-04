package com.sherbin.PasswordManagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableWebSecurity
@Configuration
@CrossOrigin(origins="http://localhost:4200/")
public class SecurityConfigurations {

    private static final String[] WHITE_LIST_URLS = {
            "/user",
            "/user/{id}",
            "/{userId}/data",
            "/data",
            "user/{userId}",
            "/data/{id}",
            "user/{userDataId}",
            "/login",
            "/userid",
            "/loginalluser"


    };
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST_URLS).permitAll();

        return  http.build();
    }
}
