package com.aquiteturahexa.techchallenge.adapters.infra;

import com.aquiteturahexa.techchallenge.core.ports.in.CreateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.OrderServicePort;
import com.aquiteturahexa.techchallenge.core.ports.in.UserServicePort;
import com.aquiteturahexa.techchallenge.core.ports.out.GetOrderByIdPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.OrderRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.out.SaveOrderPort;
import com.aquiteturahexa.techchallenge.core.ports.out.UserRepositoryPort;
import com.aquiteturahexa.techchallenge.core.service.CreateOrderService;
import com.aquiteturahexa.techchallenge.core.service.GetOrderService;
import com.aquiteturahexa.techchallenge.core.service.OrderService;
import com.aquiteturahexa.techchallenge.core.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public OrderServicePort orderServicePort(OrderRepositoryPort orderRepositoryPort) {

        return new OrderService(orderRepositoryPort);
    }

    @Bean
    public CreateOrderPortIn beanCreateOrderPortIn(SaveOrderPort saveOrderPort) {
        return new CreateOrderService(saveOrderPort);
    }

    @Bean
    public GetOrderPortIn beanGetOrderPortIn(GetOrderByIdPortOut getOrderByIdPortOut) {
        return new GetOrderService(getOrderByIdPortOut);
    }

}
