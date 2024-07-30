package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

import java.time.ZonedDateTime;
import java.util.List;

public interface SearchOrderGateway {
    List<Order> search(ZonedDateTime start,
                       ZonedDateTime end,
                       List<Status> status,
                       Client requester);
}
