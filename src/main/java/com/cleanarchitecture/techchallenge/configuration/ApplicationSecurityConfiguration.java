package com.cleanarchitecture.techchallenge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cleanarchitecture.techchallenge.api.rest.provider.JwtAuthFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfiguration {

    private static final String[] ENDPOINTS_ADMIN = {
            "api/v1/clients",
            "api/v1/clients/{id}"
    };
    private static final String[] ENDPOINTS_OPEN = {
            "api/v1/followup",
            "api/v1/orders/{id}/payment/{status}"
    };
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(ENDPOINTS_ADMIN).hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "api/v1/items").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "api/v1/items/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "api/v1/items").permitAll()
                .requestMatchers(HttpMethod.GET, "api/v1/items/{id}").permitAll()
                .requestMatchers(ENDPOINTS_OPEN).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
