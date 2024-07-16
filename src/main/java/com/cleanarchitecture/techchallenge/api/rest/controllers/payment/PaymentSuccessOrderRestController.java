package com.cleanarchitecture.techchallenge.api.rest.controllers.payment;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.usecases.RefusedPaymentUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderMapper;
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
public class PaymentSuccessOrderRestController {

    private static final String FAILED = "failed";
    private final GetOrderUseCase getOrderUseCase;
    private final RefusedPaymentUseCase refusedPaymentUseCase;
    private final EffecitvePaymentUseCase effecitvePaymentUseCase;
    private final ReceiveOrderUseCase receiveOrderUseCase;

    @PatchMapping(path = "/api/v1/orders/{id}/payment/{status}")
    @Operation(summary = "Receive order payment statuss")
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
        var order = getOrderUseCase.get(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (FAILED.equalsIgnoreCase(status)) {
            refusedPaymentUseCase.refused(order.get());
            return ResponseEntity.noContent().build();
        } else {
            var updatedOrder = effecitvePaymentUseCase.pay(order.get());
            updatedOrder = receiveOrderUseCase.receive(updatedOrder);

            return ResponseEntity.ok()
                    .body(OrderMapper.toFollowUpDto(updatedOrder));
        }
    }

}
