package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GetOrderByIdRestController {

    private final GetOrderPortIn getOrderPortIn;

    @GetMapping(path = "/api/v1/orders/{id}")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @PathVariable("id") String id) {

        var order = getOrderPortIn.get(id);

        return order.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(order);
    }

}
