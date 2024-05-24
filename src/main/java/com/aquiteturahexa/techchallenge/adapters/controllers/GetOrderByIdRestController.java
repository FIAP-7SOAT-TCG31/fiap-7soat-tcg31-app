package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Get Order By Id Controller", description = "Controller for return order data by his id")
public class GetOrderByIdRestController {

    private final GetOrderPortIn getOrderPortIn;

    @GetMapping(path = "/api/v1/orders/{id}")
    @Operation(summary = "Return order data by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned order data"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @PathVariable("id") String id) {

        var order = getOrderPortIn.get(id);

        return order.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(order);
    }

}
