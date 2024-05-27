package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ItemDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateItemDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ItemMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateItemPortIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
@Tag(name = "Update Item Controller", description = "Controller for update item and save in database")
public class UpdateItemRestController {

    private final UpdateItemPortIn updateItemPortIn;

    @PutMapping(path = "/api/v1/items/{id}")
    @Operation(summary = "Update Item")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Receive updated item data and save it in the database",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ItemDto.class))),
            @ApiResponse(responseCode = "404", description = "Item not found")
    })
    public ResponseEntity<?> updateItem(
            @RequestHeader Map<String, String> headers,
            @PathVariable("id") String id,
            @RequestBody RequestCreateItemDto body) {

        var updatedItem = updateItemPortIn.update(
                Long.parseLong(id),
                ItemMapper.toDomain(body.getItem()));

        if (isNull(updatedItem)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedItem);
    }

}
