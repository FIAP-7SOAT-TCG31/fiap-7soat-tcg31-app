package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.usecases.SearchOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.order.SearchOrderGateway;

import java.time.ZonedDateTime;
import java.util.List;

public class SearchOrderService implements SearchOrderUseCase {

    private final SearchOrderGateway searchOrderGateway;

    public SearchOrderService(SearchOrderGateway searchOrderGateway) {
        this.searchOrderGateway = searchOrderGateway;
    }

    @Override
    public List<Order> search(ZonedDateTime start, ZonedDateTime end, List<Status> status, Client requester) {
        return searchOrderGateway.search(start, end, status, requester);
    }
}
