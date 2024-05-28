package com.aquiteturahexa.techchallenge.adapters.infra;

import com.aquiteturahexa.techchallenge.adapters.controllers.provider.UserDetailsServiceImpl;
import com.aquiteturahexa.techchallenge.core.ports.in.AdvanceStatusPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateClientPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateUserPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.EffecitvePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.EncodePasswordPortOut;
import com.aquiteturahexa.techchallenge.core.ports.in.GeneratePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByDocumentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByIdPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.ReceiveOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateClientPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateUserPorOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GeneratePaymentPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByDocumentPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByIdPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserPortOut;
import com.aquiteturahexa.techchallenge.core.service.AdvanceStatusService;
import com.aquiteturahexa.techchallenge.core.service.CreateClientService;
import com.aquiteturahexa.techchallenge.core.service.CreateUserService;
import com.aquiteturahexa.techchallenge.core.service.EffecitvePaymentService;
import com.aquiteturahexa.techchallenge.core.service.GeneratePaymentService;
import com.aquiteturahexa.techchallenge.core.service.GetClientByDocumentService;
import com.aquiteturahexa.techchallenge.core.service.GetClientByIdService;
import com.aquiteturahexa.techchallenge.core.service.GetUserService;
import com.aquiteturahexa.techchallenge.core.service.ReceiveOrderService;
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
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

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
    public CreateClientPortIn beanCreateClientPortIn(CreateClientPortOut createClientPortOut) {
        return new CreateClientService(createClientPortOut);
    }

    @Bean
    public GetClientByIdPortIn beanGetClientByIdPortIn(GetClientByIdPortOut getClientByIdPortOut) {
        return new GetClientByIdService(getClientByIdPortOut);
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
    public GetUserPortIn beanGetUserPortIn(GetUserPortOut getUserPortOut, EncodePasswordPortOut encodePasswordPortOut) {
        return new GetUserService(getUserPortOut, encodePasswordPortOut);
    }

    @Bean
    public CreateUserPortIn beanCreateUserPortIn(CreateUserPorOut createUserPorOut, EncodePasswordPortOut encodePasswordPortOut) {
        return new CreateUserService(createUserPorOut, encodePasswordPortOut);
    }

    @Bean
    public UserDetailsService userDetailsService(GetUserPortIn getUserPortIn) {
        return new UserDetailsServiceImpl(getUserPortIn);
    }

    @Bean
    public GeneratePaymentPortIn beanGeneratePaymentPortIn(List<GeneratePaymentPortOut> generatePaymentPortOut, UpdateOrderPortOut updateOrderPortOut) {
        return new GeneratePaymentService(generatePaymentPortOut, updateOrderPortOut);
    }

    @Bean
    public EffecitvePaymentPortIn beanEffecitvePaymentPortIn(UpdateOrderPortOut updateOrderPortOut) {
        return new EffecitvePaymentService(updateOrderPortOut);
    }

    @Bean
    public AdvanceStatusPortIn beanAdvanceStatusPortIn(UpdateOrderPortOut updateOrderPortOut) {
        return new AdvanceStatusService(updateOrderPortOut);
    }

    @Bean
    public ReceiveOrderPortIn beanReceiveOrderPortIn(UpdateOrderPortOut updateOrderPortOut) {
        return new ReceiveOrderService(updateOrderPortOut);
    }


}
