package com.cleanarchitecture.techchallenge.configuration;

import com.cleanarchitecture.techchallenge.api.rest.provider.UserDetailsServiceImpl;
import com.cleanarchitecture.techchallenge.application.services.AdvanceStatusService;
import com.cleanarchitecture.techchallenge.application.services.CreateClientService;
import com.cleanarchitecture.techchallenge.application.services.CreateItemService;
import com.cleanarchitecture.techchallenge.application.services.CreateOrderService;
import com.cleanarchitecture.techchallenge.application.services.CreateUserService;
import com.cleanarchitecture.techchallenge.application.services.EffecitvePaymentService;
import com.cleanarchitecture.techchallenge.application.services.GeneratePaymentService;
import com.cleanarchitecture.techchallenge.application.services.GetClientByDocumentService;
import com.cleanarchitecture.techchallenge.application.services.GetClientByIdService;
import com.cleanarchitecture.techchallenge.application.services.GetItemService;
import com.cleanarchitecture.techchallenge.application.services.GetOrderService;
import com.cleanarchitecture.techchallenge.application.services.GetUserService;
import com.cleanarchitecture.techchallenge.application.services.ListItemsService;
import com.cleanarchitecture.techchallenge.application.services.ReceiveOrderService;
import com.cleanarchitecture.techchallenge.application.services.RefusedPaymentService;
import com.cleanarchitecture.techchallenge.application.services.SearchOrderService;
import com.cleanarchitecture.techchallenge.application.services.UpdateItemService;
import com.cleanarchitecture.techchallenge.application.services.UpdateOrderService;
import com.cleanarchitecture.techchallenge.domain.usecases.AdvanceStatusUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateClientUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateItemUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateUserUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.EffecitvePaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GeneratePaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByDocumentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByIdUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetItemUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetUserUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.ListItemsUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.ReceiveOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.RefusedPaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.SearchOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateItemUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.client.CreateClientGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.client.GetClientByDocumentGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.client.GetClientByIdGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.item.CreateItemGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.item.GetItemGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.item.ListItemsGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.item.UpdateItemGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.order.GetOrderByIdGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.order.SaveOrderGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.order.SearchOrderGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.order.UpdateOrderGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.payment.GeneratePaymentGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.user.CreateUserGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.user.EncodePasswordGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.user.GetUserGateway;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

@Configuration
public class ApplicationBeansConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CreateClientUseCase beanCreateClientPortIn(CreateClientGateway createClientGateway) {
        return new CreateClientService(createClientGateway);
    }

    @Bean
    public GetClientByIdUseCase beanGetClientByIdPortIn(GetClientByIdGateway getClientByIdGateway) {
        return new GetClientByIdService(getClientByIdGateway);
    }

    @Bean
    public GetClientByDocumentUseCase beanGetClientByDocumentPortIn(GetClientByDocumentGateway getClientByDocumentGateway) {
        return new GetClientByDocumentService(getClientByDocumentGateway);
    }


    @Bean
    public CreateOrderUseCase beanCreateOrderPortIn(SaveOrderGateway saveOrderGateway) {
        return new CreateOrderService(saveOrderGateway);
    }

    @Bean
    public GetOrderUseCase beanGetOrderPortIn(GetOrderByIdGateway getOrderByIdGateway) {
        return new GetOrderService(getOrderByIdGateway);
    }

    @Bean
    public UpdateOrderUseCase beanUpdateOrderPortIn(UpdateOrderGateway updateOrderGateway) {
        return new UpdateOrderService(updateOrderGateway);
    }

    @Bean
    public SearchOrderUseCase beanSearchOrderService(SearchOrderGateway searchOrderGateway) {
        return new SearchOrderService(searchOrderGateway);
    }

    @Bean
    public CreateItemUseCase beanCreateItemPortIn(CreateItemGateway createItemGateway) {
        return new CreateItemService(createItemGateway);
    }

    @Bean
    public GetItemUseCase beanGetItemPortIn(GetItemGateway getItemGateway) {
        return new GetItemService(getItemGateway);
    }

    @Bean
    public ListItemsUseCase beanListItemsPortIn(ListItemsGateway listItemsGateway) {
        return new ListItemsService(listItemsGateway);
    }

    @Bean
    public UpdateItemUseCase beanUpdateItemPortIn(
            GetItemGateway getItemGateway,
            UpdateItemGateway updateItemGateway) {
        return new UpdateItemService(getItemGateway, updateItemGateway);
    }

    @Bean
    public GetUserUseCase beanGetUserPortIn(GetUserGateway getUserGateway, EncodePasswordGateway encodePasswordGateway) {
        return new GetUserService(getUserGateway, encodePasswordGateway);
    }

    @Bean
    public CreateUserUseCase beanCreateUserPortIn(CreateUserGateway createUserGateway, EncodePasswordGateway encodePasswordGateway) {
        return new CreateUserService(createUserGateway, encodePasswordGateway);
    }

    @Bean
    public UserDetailsService userDetailsService(GetUserUseCase getUserUseCase) {
        return new UserDetailsServiceImpl(getUserUseCase);
    }

    @Bean
    public GeneratePaymentUseCase beanGeneratePaymentPortIn(List<GeneratePaymentGateway> generatePaymentGateway, UpdateOrderGateway updateOrderGateway) {
        return new GeneratePaymentService(generatePaymentGateway, updateOrderGateway);
    }

    @Bean
    public EffecitvePaymentUseCase beanEffecitvePaymentPortIn(UpdateOrderGateway updateOrderGateway) {
        return new EffecitvePaymentService(updateOrderGateway);
    }

    @Bean
    public RefusedPaymentUseCase beanRefusedPaymentUseCase(UpdateOrderGateway updateOrderGateway) {
        return new RefusedPaymentService(updateOrderGateway);
    }

    @Bean
    public AdvanceStatusUseCase beanAdvanceStatusPortIn(UpdateOrderGateway updateOrderGateway) {
        return new AdvanceStatusService(updateOrderGateway);
    }

    @Bean
    public ReceiveOrderUseCase beanReceiveOrderPortIn(UpdateOrderGateway updateOrderGateway) {
        return new ReceiveOrderService(updateOrderGateway);
    }


}
