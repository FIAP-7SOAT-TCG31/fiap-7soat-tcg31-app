package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;

import java.time.ZonedDateTime;
import java.util.List;

public interface SearchOrderUseCase {
    List<Order> search(ZonedDateTime start,
                       ZonedDateTime end,
                       List<Status> status,
                       Client requester);
}
