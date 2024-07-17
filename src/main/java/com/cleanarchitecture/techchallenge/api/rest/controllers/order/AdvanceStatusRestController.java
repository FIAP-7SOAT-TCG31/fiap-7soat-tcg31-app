package com.cleanarchitecture.techchallenge.api.rest.controllers.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.infra.controllers.order.AdvanceStatusController;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import com.cleanarchitecture.techchallenge.domain.usecases.AdvanceStatusUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Order Status Controller", description = "Controller for managing order status")
public class AdvanceStatusRestController {

    private final AdvanceStatusController advanceStatusController;

    @PatchMapping(path = "/api/v1/orders/{id}/status")
    @Operation(summary = "Advance the status of an order")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully advanced the order status",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseFollowupDto.class))),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @Parameter(description = "The ID of the order to advance status") @PathVariable("id") String id) {

        var followup = advanceStatusController.create(id);

        return followup == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok()
                .body(followup);
    }
}