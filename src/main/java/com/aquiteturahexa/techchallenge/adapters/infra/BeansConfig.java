package com.aquiteturahexa.techchallenge.adapters.infra;

import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByDocumentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByDocumentPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserPortOut;
import com.aquiteturahexa.techchallenge.core.service.GetClientByDocumentService;
import com.aquiteturahexa.techchallenge.core.service.GetUserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aquiteturahexa.techchallenge.core.ports.in.CreateItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.ListItemsPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.OrderServicePort;
import com.aquiteturahexa.techchallenge.core.ports.in.SearchOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.ClientServicePort;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateItemPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetItemPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetOrderByIdPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.ListItemsPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.OrderRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.out.SaveOrderPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.SearchOrderPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateItemPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.ClientRepositoryPort;
import com.aquiteturahexa.techchallenge.core.service.CreateItemService;
import com.aquiteturahexa.techchallenge.core.service.CreateOrderService;
import com.aquiteturahexa.techchallenge.core.service.GetItemService;
import com.aquiteturahexa.techchallenge.core.service.GetOrderService;
import com.aquiteturahexa.techchallenge.core.service.ListItemsService;
import com.aquiteturahexa.techchallenge.core.service.OrderService;
import com.aquiteturahexa.techchallenge.core.service.SearchOrderService;
import com.aquiteturahexa.techchallenge.core.service.UpdateItemService;
import com.aquiteturahexa.techchallenge.core.service.UpdateOrderService;
import com.aquiteturahexa.techchallenge.core.service.ClientService;

@Configuration
public class BeansConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ClientServicePort clientServicePort(ClientRepositoryPort clientRepositoryPort) {
        return new ClientService(clientRepositoryPort);
    }

    @Bean
    public GetClientByDocumentPortIn beanGetClientByDocumentPortIn(GetClientByDocumentPortOut getClientByDocumentPortOut) {
        return new GetClientByDocumentService(getClientByDocumentPortOut);
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

    @Bean
    public CreateItemPortIn beanCreateItemPortIn(CreateItemPortOut createItemPortOut) {
        return new CreateItemService(createItemPortOut);
    }

    @Bean
    public GetItemPortIn beanGetItemPortIn(GetItemPortOut getItemPortOut) {
        return new GetItemService(getItemPortOut);
    }

    @Bean
    public ListItemsPortIn beanListItemsPortIn(ListItemsPortOut listItemsPortOut) {
        return new ListItemsService(listItemsPortOut);
    }

    @Bean
    public UpdateItemPortIn beanUpdateItemPortIn(UpdateItemPortOut updateItemPortOut) {
        return new UpdateItemService(updateItemPortOut);
    }

    @Bean
    public GetUserPortIn beanGetUserPortIn(GetUserPortOut getUserPortOut) {
        return new GetUserService(getUserPortOut);
    }
}
