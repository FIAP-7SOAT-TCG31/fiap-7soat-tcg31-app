package com.cleanarchitecture.techchallenge.infra.controllers.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.usecases.AdvanceStatusUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.springframework.stereotype.Component;

@Component
public class AdvanceStatusController {

    private final GetOrderUseCase getOrderUseCase;
    private final AdvanceStatusUseCase advanceStatusUseCase;
    private final OrderPresenter orderPresenter;

    public AdvanceStatusController(AdvanceStatusUseCase advanceStatusUseCase, GetOrderUseCase getOrderUseCase) {
        this.advanceStatusUseCase = advanceStatusUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.orderPresenter = OrderPresenter.getInstance();
    }

    public ResponseFollowupDto create(String id) {
        var order = getOrderUseCase.get(id);

        if (order.isEmpty()) {
            return null;
        }

        var updatedOrder = advanceStatusUseCase.advance(order.get());
        return orderPresenter.toFollowUpDto(order.get());
    }
}