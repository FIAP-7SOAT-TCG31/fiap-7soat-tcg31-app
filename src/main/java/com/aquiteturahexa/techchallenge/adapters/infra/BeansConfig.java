package com.aquiteturahexa.techchallenge.adapters.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aquiteturahexa.techchallenge.core.ports.UserRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.UserServicePort;
import com.aquiteturahexa.techchallenge.core.service.UserService;

@Configuration
public class BeansConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserServicePort userServicePort(UserRepositoryPort userRepositoryPort) {

        return new UserService(userRepositoryPort);
    }
}
