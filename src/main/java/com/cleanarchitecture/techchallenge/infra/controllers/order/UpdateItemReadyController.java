package com.cleanarchitecture.techchallenge.infra.controllers.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.RequestUpdateOrderDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ComboPresenter;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.springframework.stereotype.Component;


@Component
public class UpdateItemReadyController {

    private final GetOrderUseCase getOrderUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;
    private final OrderPresenter orderPresenter;
    private final ComboPresenter comboPresenter;

    public UpdateItemReadyController(UpdateOrderUseCase updateOrderUseCase, GetOrderUseCase getOrderUseCase) {
        this.updateOrderUseCase = updateOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.orderPresenter = OrderPresenter.getInstance();
        this.comboPresenter = ComboPresenter.getInstance();
    }

    public OrderDto update(String id, RequestUpdateOrderDto body) {

        var combo = comboPresenter.toDomain(body.getCombo());
        var order = getOrderUseCase.get(id);
        return order.map(value -> orderPresenter.toDto(updateOrderUseCase.update(value, combo))).orElse(null);
    }

}
