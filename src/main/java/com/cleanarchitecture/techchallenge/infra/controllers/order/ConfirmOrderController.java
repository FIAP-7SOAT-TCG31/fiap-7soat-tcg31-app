package com.cleanarchitecture.techchallenge.infra.controllers.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.payment.PaymentDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GeneratePaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import com.cleanarchitecture.techchallenge.infra.presenters.payment.PaymentPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Component
public class ConfirmOrderController {

    private final GetOrderUseCase getOrderUseCase;
    private final GeneratePaymentUseCase generatePaymentUseCase;
    private final PaymentPresenter paymentPresenter;

    public ConfirmOrderController(GeneratePaymentUseCase generatePaymentUseCase, GetOrderUseCase getOrderUseCase) {
        this.generatePaymentUseCase = generatePaymentUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.paymentPresenter = PaymentPresenter.getInstance();
    }

    public PaymentDto generatePayment(String id, PaymentDto body) {
        var order = getOrderUseCase.get(id);
        return order.map(value -> paymentPresenter.toDto(generatePaymentUseCase.generate(value, ClientPresenter.getInstance().toDomain(body.getClient()), body.getType()))).orElse(null);

    }


}
