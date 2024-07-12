package com.cleanarchitecture.techchallenge.api.rest.dtos.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ComboDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderDto {

    private Long id;
    private ClientDto requester;
    private ComboDto combo;
    private Instant requestedAt;
    private Instant updatedAt;
    private BigDecimal amount;
    private String status;
}
