package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.PaymentDto;
import com.aquiteturahexa.techchallenge.core.ports.in.GeneratePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import io.swagger.v3.oas.annotations.Operation;
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

    private final GetOrderPortIn getOrderPortIn;
    private final GeneratePaymentPortIn generatePaymentPortIn;

    @PostMapping(path = "/api/v1/orders/{id}/payment")
    @Operation(summary = "Confirm order and start payment flux")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully confirmed order"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> generatePayment(@RequestHeader Map<String, String> headers,
                                             @PathVariable("id") String id,
                                             @RequestBody PaymentDto body) {

        var order = getOrderPortIn.get(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var payment = generatePaymentPortIn.generate(order.get(), body.getType());

        return ResponseEntity.created(null)
                .body(Map.of(body.getType(), payment.getPaymentDetails().get("QR_CODE")));
    }

}
