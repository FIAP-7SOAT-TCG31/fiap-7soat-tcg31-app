package com.cleanarchitecture.techchallenge.api.rest.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.infra.controllers.order.SearchOrdersController;
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

import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Search Order Controller", description = "Controller for return order data")
public class SearchOrdersRestController {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private final SearchOrdersController searchOrdersController;

    @GetMapping(path = "/api/v1/orders")
    @Operation(summary = "Return order data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned order data",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ResponseFollowupDto.class)))),
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @RequestParam(value = "status", required = false) List<String> status,
                                 @RequestParam(value = "client_id", required = false) Long clientId,
                                 @RequestParam(value = "from", required = false) String fromDate,
                                 @RequestParam(value = "to", required = false) String toDate) {

        var orders = searchOrdersController.get(status, clientId, fromDate, toDate);

        return orders.isEmpty()
                ? ResponseEntity.ok(List.of())
                : ResponseEntity.ok(orders);
    }

}
