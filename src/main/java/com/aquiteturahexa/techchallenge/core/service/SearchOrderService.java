package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.in.SearchOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.SearchOrderPortOut;

import java.time.ZonedDateTime;
import java.util.List;

public class SearchOrderService implements SearchOrderPortIn {

    private final SearchOrderPortOut searchOrderPortOut;

    public SearchOrderService(SearchOrderPortOut searchOrderPortOut) {
        this.searchOrderPortOut = searchOrderPortOut;
    }

    @Override
    public List<Order> search(ZonedDateTime start, ZonedDateTime end, List<Status> status, Client requester) {
        return searchOrderPortOut.search(start, end, status, requester);
    }
}
