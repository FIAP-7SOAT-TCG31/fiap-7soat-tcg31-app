package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.OrderMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.AdvanceStatusPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.EffecitvePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AdvanceStatusRestController {

    private final GetOrderPortIn getOrderPortIn;
    private final AdvanceStatusPortIn advanceStatusPortIn;

    @PatchMapping(path = "/api/v1/orders/{id}/status")
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers, @PathVariable("id") String id) {
        var order = getOrderPortIn.get(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var updatedOrder = advanceStatusPortIn.advance(order.get());

        return ResponseEntity.ok()
                .body(OrderMapper.toDto(updatedOrder));
    }
}
