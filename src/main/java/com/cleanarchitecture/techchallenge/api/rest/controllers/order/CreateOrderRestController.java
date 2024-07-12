package com.cleanarchitecture.techchallenge.api.rest.controllers.order;

import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientMapper;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ComboMapper;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderMapper;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.RequestCreateOrderDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Create Order Controller", description = "Controller for receiving order data and save it in the database")
public class CreateOrderRestController {

    private final CreateOrderUseCase createOrderUseCase;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/api/v1/orders")
    @Operation(summary = "Create order data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Receive order data and save it in the database",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderDto.class)))
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody RequestCreateOrderDto body) {

        var combo = ComboMapper.toDomain(body.getCombo());
        var client = ClientMapper.toDomain(body.getRequester());

        var order = createOrderUseCase.create(combo, client);

        final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(OrderMapper.toDto(order));
    }

}
