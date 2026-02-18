package com.example.funciona.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    private JwtFilter jwtFilter;

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception{
        http.csrf(csrf ->csrf.disable())
        .sessionManagement(
            s -> s
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login","/register","/css/**").permitAll()
                .anyRequest().authenticated())
                .addFilterBefore(jwtFilter, 
                    UsernamePasswordAuthenticationFilter.class);
                    return http.build();
    }
}
