package com.cleanarchitecture.techchallenge.infra.controllers.order;


import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.SearchOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.order.OrderPresenter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FollowUpOrdersController {

    private final SearchOrderUseCase searchOrderUseCase;
    private final OrderPresenter orderPresenter;

    public FollowUpOrdersController(SearchOrderUseCase searchOrderUseCase) {
        this.searchOrderUseCase = searchOrderUseCase;
        this.orderPresenter = OrderPresenter.getInstance();
    }

    public Map<String, List<ResponseFollowupDto>> get() {

        List<Status> statusList = new ArrayList<>(Arrays.asList(Status.values()));
        statusList.removeAll(List.of(Status.CREATED, Status.AWAITING_PAYMENT, Status.PAID, Status.FINISHED, Status.CANCELLED));

        var orders = searchOrderUseCase.search(null,
                null,
                statusList,
                null);


        Comparator<Status> statusComparator = Comparator.comparingInt(status -> {
            return switch (status) {
                case READY -> 1;
                case IN_PREPARATION -> 2;
                case RECEIVED -> 3;
                default -> 4;
            };
        });

        return orders.isEmpty()
                ? Map.of()
                : orders
                .stream()
                .sorted(Comparator.comparing(Order::getUpdatedAt))
                .sorted(Comparator.comparing(Order::getStatus, statusComparator))
                .map(orderPresenter::toFollowUpDto)
                .collect(Collectors.groupingBy(ResponseFollowupDto::getStatus));

    }

}


