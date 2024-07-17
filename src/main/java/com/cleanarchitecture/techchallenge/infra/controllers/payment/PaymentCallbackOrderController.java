package com.cleanarchitecture.techchallenge.infra.controllers.payment;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.domain.usecases.EffecitvePaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.ReceiveOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.RefusedPaymentUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.springframework.stereotype.Component;

@Component
public class PaymentCallbackOrderController {

    private static final String FAILED = "failed";
    private final GetOrderUseCase getOrderUseCase;
    private final RefusedPaymentUseCase refusedPaymentUseCase;
    private final EffecitvePaymentUseCase effecitvePaymentUseCase;
    private final ReceiveOrderUseCase receiveOrderUseCase;
    private final OrderPresenter orderPresenter;

    public PaymentCallbackOrderController(ReceiveOrderUseCase receiveOrderUseCase, EffecitvePaymentUseCase effecitvePaymentUseCase, RefusedPaymentUseCase refusedPaymentUseCase, GetOrderUseCase getOrderUseCase) {
        this.receiveOrderUseCase = receiveOrderUseCase;
        this.effecitvePaymentUseCase = effecitvePaymentUseCase;
        this.refusedPaymentUseCase = refusedPaymentUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.orderPresenter = OrderPresenter.getInstance();
    }

    public OrderDto create(String id, String status) {
        var order = getOrderUseCase.get(id);

        if (order.isEmpty()) {
            return null;
        }

        if (FAILED.equalsIgnoreCase(status)) {
            refusedPaymentUseCase.refused(order.get());
        } else {
            var updatedOrder = effecitvePaymentUseCase.pay(order.get());
            receiveOrderUseCase.receive(updatedOrder);
        }

        return orderPresenter.toDto(order.get());
    }

}
