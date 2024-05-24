package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateItemDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ItemMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateItemPortIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Create Item Controller", description = "Controller for receiving item data and save it in the database")
public class CreateItemRestController {

    private final CreateItemPortIn createItemPortIn;

    @PostMapping(path = "/api/v1/items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Receive item data and save it in the database")
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody RequestCreateItemDto body) {

        var itemToCreate = ItemMapper.toDomain(body.getItem());
        var item = createItemPortIn.create(itemToCreate);

        final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(ItemMapper.toDto(item));
    }

}
