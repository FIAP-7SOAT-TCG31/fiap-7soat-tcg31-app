package com.aquiteturahexa.techchallenge.adapters.infra;

import com.aquiteturahexa.techchallenge.core.ports.in.CreateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.OrderServicePort;
import com.aquiteturahexa.techchallenge.core.ports.in.SearchOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.UserServicePort;
import com.aquiteturahexa.techchallenge.core.ports.out.GetOrderByIdPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.OrderRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.out.SaveOrderPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.SearchOrderPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.UserRepositoryPort;
import com.aquiteturahexa.techchallenge.core.service.CreateOrderService;
import com.aquiteturahexa.techchallenge.core.service.GetOrderService;
import com.aquiteturahexa.techchallenge.core.service.OrderService;
import com.aquiteturahexa.techchallenge.core.service.SearchOrderService;
import com.aquiteturahexa.techchallenge.core.service.UpdateOrderService;
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
    public CreateOrderPortIn beanCreateOrderPortIn(SaveOrderPortOut saveOrderPortOut) {
        return new CreateOrderService(saveOrderPortOut);
    }

    @Bean
    public GetOrderPortIn beanGetOrderPortIn(GetOrderByIdPortOut getOrderByIdPortOut) {
        return new GetOrderService(getOrderByIdPortOut);
    }

    @Bean
    public UpdateOrderPortIn beanUpdateOrderPortIn(UpdateOrderPortOut updateOrderPortOut) {
        return new UpdateOrderService(updateOrderPortOut);
    }

    @Bean
    public SearchOrderPortIn beanSearchOrderService(SearchOrderPortOut searchOrderPortOut) {
        return new SearchOrderService(searchOrderPortOut);
    }


}
