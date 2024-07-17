package com.cleanarchitecture.techchallenge.api.rest.controllers.payment;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.usecases.RefusedPaymentUseCase;
import com.cleanarchitecture.techchallenge.infra.controllers.payment.PaymentCallbackOrderController;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import com.cleanarchitecture.techchallenge.domain.usecases.EffecitvePaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.ReceiveOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Pay Order Controller", description = "Controller for receive order payment")
public class PaymentCallbackOrderRestController {

    private final PaymentCallbackOrderController paymentCallbackOrderController;

    @PatchMapping(path = "/api/v1/orders/{id}/payment/{status}")
    @Operation(summary = "Receive order payment status and update it in the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Order payment status updated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseFollowupDto.class))
            ),
            @ApiResponse(responseCode = "204", description = "Order cancelled"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers, @PathVariable("id") String id, @PathVariable("status") String status) {
        var order = paymentCallbackOrderController.create(id, status);

        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        return order.getStatus().equalsIgnoreCase("CANCELLED")
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(order);
    }

}
