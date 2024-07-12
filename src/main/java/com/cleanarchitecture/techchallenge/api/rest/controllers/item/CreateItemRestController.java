package com.cleanarchitecture.techchallenge.api.rest.controllers.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.item.RequestCreateItemDto;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ItemMapper;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    private final CreateItemUseCase createItemUseCase;

    @PostMapping(path = "/api/v1/items")
    @Operation(summary = "Create item data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Receive item data and save it in the database",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemDto.class)))
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody RequestCreateItemDto body) {

        var itemToCreate = ItemMapper.toDomain(body.getItem());
        var item = createItemUseCase.create(itemToCreate);

        final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(ItemMapper.toDto(item));
    }

}
