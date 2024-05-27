package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ItemDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ItemMapper;
import com.aquiteturahexa.techchallenge.core.model.ItemType;
import com.aquiteturahexa.techchallenge.core.ports.in.ListItemsPortIn;
import io.micrometer.common.util.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Search Item Controller", description = "Controller for return item data")
public class ListItemsRestController {

    private final ListItemsPortIn listItemsPortIn;

    @GetMapping(path = "/api/v1/items")
    @Operation(summary = "Return item data")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully returned items data",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ItemDto.class)))),
    })
    public ResponseEntity<?> getById(
            @RequestHeader Map<String, String> headers,
            @RequestParam(value = "itemType", required = false) String itemType

    ) {
        var filterByType = StringUtils.isNotEmpty(itemType);
        var itemTypeEnum = filterByType ? ItemType.valueOf(itemType) : null;

        var items = filterByType
                ? listItemsPortIn.getAllByType(itemTypeEnum)
                : listItemsPortIn.getAll();

        return items.isEmpty()
                ? ResponseEntity.ok(List.of())
                : ResponseEntity.ok(ItemMapper.toDto(items));

    }

}
