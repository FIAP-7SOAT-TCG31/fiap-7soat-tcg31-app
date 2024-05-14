package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.model.User;

import java.time.ZonedDateTime;
import java.util.List;

public interface SearchOrderPortOut {
    List<Order> search(ZonedDateTime start,
                       ZonedDateTime end,
                       Status status,
                       User requester);
}
