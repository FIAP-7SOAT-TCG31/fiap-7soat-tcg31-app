package com.cleanarchitecture.techchallenge.api.rest.controllers.order;


import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderMapper;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByIdUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.SearchOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
@Tag(name = "Search Order Controller", description = "Controller for return order data")
public class SearchOrdersRestController {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private final SearchOrderUseCase searchOrderUseCase;
    private final GetClientByIdUseCase getClientByIdUseCase;

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


        Client client = null;
        List<Status> statusEnums = CollectionUtils.isEmpty(status) ? List.of() : status.stream().map(Status::valueOf).toList();

        if (clientId != null) {
            client = getClientByIdUseCase.find(clientId).orElse(null);
        }

        LocalDate from = StringUtils.isBlank(fromDate) ? null : LocalDate.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate to = StringUtils.isBlank(toDate) ? null : LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        var orders = searchOrderUseCase.search(isNull(from) ? null : from.atStartOfDay().atZone(ZONE_ID),
                isNull(to) ? null : to.atStartOfDay().atZone(ZONE_ID),
                statusEnums,
                client);

        return orders.isEmpty()
                ? ResponseEntity.ok(List.of())
                : ResponseEntity.ok(OrderMapper.toDto(orders));
    }

}
