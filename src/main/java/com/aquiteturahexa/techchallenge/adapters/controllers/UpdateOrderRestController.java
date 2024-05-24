package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ComboDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestUpdateOrderDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ComboMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateOrderPortIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@Tag(name = "Update Order Controller", description = "Controller for update order and save in database")
public class UpdateOrderRestController {

    private final GetOrderPortIn getOrderPortIn;
    private final UpdateOrderPortIn updateOrderPortIn;

    @PatchMapping(path = "/api/v1/orders/{id}")    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Receive updated order data and save it in the database"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> update(@RequestHeader Map<String, String> headers,
                                    @PathVariable("id") String id,
                                    @RequestBody RequestUpdateOrderDto body) {

        var combo = ComboMapper.toDomain(body.getCombo());

        var order = getOrderPortIn.get(id);

        if (order.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        var orderUpdated = updateOrderPortIn.update(order.get(), combo);

        return ResponseEntity
                .ok(orderUpdated);
    }

}
