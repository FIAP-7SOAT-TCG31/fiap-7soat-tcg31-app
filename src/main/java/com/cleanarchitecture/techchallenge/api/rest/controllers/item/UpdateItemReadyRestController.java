package com.cleanarchitecture.techchallenge.api.rest.controllers.item;

import com.cleanarchitecture.techchallenge.infra.presenters.item.ComboMapper;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderMapper;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.RequestUpdateOrderDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateOrderUseCase;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@Tag(name = "Update Order Controller", description = "Controller for update order and save in database")
public class UpdateItemReadyRestController {

    private final GetOrderUseCase getOrderUseCase;
    private final UpdateOrderUseCase updateOrderUseCase;

    @PatchMapping(path = "/api/v1/orders/{id}/combo")
    @Operation(summary = "Flag Order Item is Ready")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Receive updated order data and save it in the database",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderDto.class))),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> update(@RequestHeader Map<String, String> headers,
                                    @PathVariable("id") String id,
                                    @RequestBody RequestUpdateOrderDto body) {

        var combo = ComboMapper.toDomain(body.getCombo());

        var order = getOrderUseCase.get(id);

        if (order.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        var orderUpdated = updateOrderUseCase.update(order.get(), combo);

        return ResponseEntity
                .ok(OrderMapper.toDto(orderUpdated));
    }

}
