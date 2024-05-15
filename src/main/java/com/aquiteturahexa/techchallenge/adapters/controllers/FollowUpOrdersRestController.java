package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ResponseFollowupDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.OrderMapper;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.SearchOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class FollowUpOrdersRestController {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private final SearchOrderPortIn searchOrderPortIn;
    private final UserServicePort userServicePort;

    @GetMapping(path = "/api/v1/followup")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers) {

        LocalDateTime from = LocalDateTime.now().minusHours(1);
        LocalDateTime to = LocalDateTime.now().plusMinutes(5);
        List<Status> statusList = new ArrayList<>(Arrays.asList(Status.values()));
        statusList.removeAll(List.of(Status.CREATED, Status.AWAITING_PAYMENT, Status.PAID, Status.FINISHED));

        var orders = searchOrderPortIn.search(from.atZone(ZONE_ID),
                to.atZone(ZONE_ID),
                statusList,
                null);

        return orders.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(
                orders
                        .stream()
                        .map(OrderMapper::toDto)
                        .collect(Collectors.groupingBy(ResponseFollowupDto::getStatus)));


    }

}


