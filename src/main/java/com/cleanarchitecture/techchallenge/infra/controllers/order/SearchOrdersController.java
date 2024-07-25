package com.cleanarchitecture.techchallenge.infra.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByIdUseCase;
import com.cleanarchitecture.techchallenge.domain.usecases.SearchOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class SearchOrdersController {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private final SearchOrderUseCase searchOrderUseCase;
    private final GetClientByIdUseCase getClientByIdUseCase;
    private final OrderPresenter orderPresenter;

    public SearchOrdersController(SearchOrderUseCase searchOrderUseCase, GetClientByIdUseCase getClientByIdUseCase) {
        this.searchOrderUseCase = searchOrderUseCase;
        this.getClientByIdUseCase = getClientByIdUseCase;
        this.orderPresenter = OrderPresenter.getInstance();
    }

    public List<OrderDto> get(List<String> status, Long clientId, String fromDate, String toDate) {


        Client client = null;
        List<Status> statusEnums = CollectionUtils.isEmpty(status) ? List.of() : status.stream().map(Status::valueOf).toList();

        if (clientId != null) {
            client = getClientByIdUseCase.find(clientId).orElse(null);
        }

        LocalDate startRange = StringUtils.isBlank(fromDate) ? null : LocalDate.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endRange = StringUtils.isBlank(toDate) ? null : LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        var orders = searchOrderUseCase.search(
                startRange == null ? null : startRange.atStartOfDay(ZONE_ID),
                endRange == null ? null : endRange.atStartOfDay(ZONE_ID),
                statusEnums,
                client);

        return orderPresenter.toDto(orders);

    }

}
