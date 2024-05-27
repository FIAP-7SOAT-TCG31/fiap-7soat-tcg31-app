package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;

import java.time.ZonedDateTime;
import java.util.List;

public interface SearchOrderPortIn {
    List<Order> search(ZonedDateTime start,
                       ZonedDateTime end,
                       List<Status> status,
                       Client requester);
}
