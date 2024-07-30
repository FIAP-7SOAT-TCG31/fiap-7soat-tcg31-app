package com.cleanarchitecture.techchallenge.infra.controllers.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.RequestCreateOrderDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ComboPresenter;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.springframework.stereotype.Component;

@Component
public class CreateOrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ComboPresenter comboPresenter;
    private final ClientPresenter clientPresenter;
    private final OrderPresenter orderPresenter;

    public CreateOrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.comboPresenter = ComboPresenter.getInstance();
        this.clientPresenter = ClientPresenter.getInstance();
        this.orderPresenter = OrderPresenter.getInstance();
    }

    public OrderDto create(RequestCreateOrderDto body) {
        var combo = comboPresenter.toDomain(body.getCombo());
        var client = clientPresenter.toDomain(body.getRequester());
        var order = createOrderUseCase.create(combo, client);
        return orderPresenter.toDto(order);
    }

}
