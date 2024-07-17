package com.cleanarchitecture.techchallenge.api.rest.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.infra.controllers.order.FollowUpOrdersController;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Follow Up Controller", description = "Controller for follow up order with waiting time")
public class FollowUpOrdersRestController {

    private final FollowUpOrdersController followUpOrdersController;

    @GetMapping(path = "/api/v1/followup")
    @Operation(summary = "Follow Up Orders")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Return orders",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ResponseFollowupDto.class)))),
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers) {
        var orders = followUpOrdersController.get();

        return orders.isEmpty()
                ? ResponseEntity.ok(List.of())
                : ResponseEntity.ok(orders);

    }

}


