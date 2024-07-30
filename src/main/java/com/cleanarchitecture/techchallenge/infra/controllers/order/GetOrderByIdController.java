package com.cleanarchitecture.techchallenge.infra.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetOrderByIdController {

    private final GetOrderUseCase getOrderUseCase;
    private final OrderPresenter orderPresenter;

    public GetOrderByIdController(GetOrderUseCase getOrderUseCase) {
        this.getOrderUseCase = getOrderUseCase;
        this.orderPresenter = OrderPresenter.getInstance();
    }

    public Optional<OrderDto> get(String id) {

        var order = getOrderUseCase.get(id);
        return order.map(orderPresenter::toDto);
    }

}
