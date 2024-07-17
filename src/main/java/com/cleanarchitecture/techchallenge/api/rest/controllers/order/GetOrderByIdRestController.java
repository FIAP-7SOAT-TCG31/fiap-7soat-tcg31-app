package com.cleanarchitecture.techchallenge.api.rest.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.infra.controllers.order.GetOrderByIdController;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    private final GetOrderByIdController getOrderByIdController;

    @GetMapping(path = "/api/v1/orders/{id}")
    @Operation(summary = "Return order data by his id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully returned order data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderDto.class))),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @PathVariable("id") String id) {

        var order = getOrderByIdController.get(id);

        return order.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(order);
    }

}
