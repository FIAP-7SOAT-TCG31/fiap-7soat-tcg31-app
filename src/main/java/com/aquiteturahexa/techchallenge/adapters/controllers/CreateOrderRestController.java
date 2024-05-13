package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateOrderDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ComboMapper;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.UserMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateOrderPortIn;
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
public class CreateOrderRestController {

    private final CreateOrderPortIn createOrderPortIn;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/api/v1/orders")
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody RequestCreateOrderDto body) {

        var combo = ComboMapper.toDomain(body.getCombo());
        var user = UserMapper.toDomain(body.getRequester());

        var order = createOrderPortIn.create(combo, user);

        final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(order);
    }

}
