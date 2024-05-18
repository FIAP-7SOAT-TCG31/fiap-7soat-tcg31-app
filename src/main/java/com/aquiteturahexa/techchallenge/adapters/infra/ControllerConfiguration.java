package com.aquiteturahexa.techchallenge.adapters.infra;


import com.aquiteturahexa.techchallenge.adapters.controllers.JwtTokenProvider;
import com.aquiteturahexa.techchallenge.adapters.controllers.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerConfiguration implements WebMvcConfigurer {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(jwtTokenProvider));
    }
}
