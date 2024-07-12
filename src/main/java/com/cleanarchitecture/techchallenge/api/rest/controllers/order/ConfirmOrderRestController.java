package com.cleanarchitecture.techchallenge.api.rest.controllers.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.payment.PaymentDto;
import com.cleanarchitecture.techchallenge.infra.presenters.payment.PaymentMapper;
import com.cleanarchitecture.techchallenge.domain.usecases.GeneratePaymentUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Confirm Order Controller", description = "Controller for confirm order and start payment flux")
public class ConfirmOrderRestController {

    private final GetOrderUseCase getOrderUseCase;
    private final GeneratePaymentUseCase generatePaymentUseCase;

    @PostMapping(path = "/api/v1/orders/{id}/payment")
    @Operation(summary = "Confirm order and start payment flux")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successfully confirmed order",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentDto.class))
            ),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> generatePayment(@RequestHeader Map<String, String> headers,
                                             @PathVariable("id") String id,
                                             @RequestBody PaymentDto body) {

        var order = getOrderUseCase.get(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var payment = generatePaymentUseCase.generate(order.get(), body.getType());

        return ResponseEntity.created(null)
                .body(PaymentMapper.toDto(payment));
    }


}
