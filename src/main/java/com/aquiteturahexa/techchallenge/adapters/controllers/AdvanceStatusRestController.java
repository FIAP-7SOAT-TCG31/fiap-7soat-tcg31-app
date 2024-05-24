package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.OrderMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.AdvanceStatusPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Tag(name = "Order Status Controller", description = "Controller for managing order status")
public class AdvanceStatusRestController {

    private final GetOrderPortIn getOrderPortIn;
    private final AdvanceStatusPortIn advanceStatusPortIn;

    @PatchMapping(path = "/api/v1/orders/{id}/status")
    @Operation(summary = "Advance the status of an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully advanced the order status"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @Parameter(description = "The ID of the order to advance status") @PathVariable("id") String id) {
        var order = getOrderPortIn.get(id);

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var updatedOrder = advanceStatusPortIn.advance(order.get());

        return ResponseEntity.ok()
                .body(OrderMapper.toDto(updatedOrder));
    }
}