package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.core.ports.in.GeneratePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ConfirmOrderRestController {

    private final GetOrderPortIn getOrderPortIn;
    private final GeneratePaymentPortIn generatePaymentPortIn;

    @PostMapping(path = "/api/v1/orders/{id}/payment")
    public ResponseEntity<?> generatePayment(@RequestHeader Map<String, String> headers, @PathVariable("id") String id) {

        var order = getOrderPortIn.get(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var payment = generatePaymentPortIn.generate(order.get());

        return ResponseEntity.created(null)
                .body(Map.of("qr_code", payment.getPaymentDetails().get("QR_CODE")));
    }

}
