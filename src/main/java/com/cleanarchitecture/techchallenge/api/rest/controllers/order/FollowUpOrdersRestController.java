package com.cleanarchitecture.techchallenge.api.rest.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderMapper;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.SearchOrderUseCase;
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

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Tag(name = "Follow Up Controller", description = "Controller for follow up order with waiting time")
public class FollowUpOrdersRestController {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private final SearchOrderUseCase searchOrderUseCase;

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

        List<Status> statusList = new ArrayList<>(Arrays.asList(Status.values()));
        statusList.removeAll(List.of(Status.CREATED, Status.AWAITING_PAYMENT, Status.PAID, Status.FINISHED, Status.CANCELLED));

        var orders = searchOrderUseCase.search(null,
                null,
                statusList,
                null);

        return orders.isEmpty()
                ? ResponseEntity.ok(List.of())
                : ResponseEntity.ok(
                orders
                        .stream()
                        .map(OrderMapper::toFollowUpDto)
                        .collect(Collectors.groupingBy(ResponseFollowupDto::getStatus)));


    }

}


