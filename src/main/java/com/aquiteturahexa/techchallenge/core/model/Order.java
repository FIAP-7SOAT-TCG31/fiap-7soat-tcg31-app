package com.aquiteturahexa.techchallenge.core.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Order {

    private Long id;
    private User requester;
    private Combo combo;
    private Instant requestedAt;
    private Instant updatedAt;
    private BigDecimal amount;
    private Status status;

    public Order(Long id,
                 User requester,
                 Combo combo,
                 Instant requestedAt,
                 Instant updatedAt,
                 BigDecimal amount,
                 Status status) {
        this.id = id;
        this.requester = requester;
        this.combo = combo;
        this.requestedAt = requestedAt;
        this.updatedAt = updatedAt;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Instant getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(Instant requestedAt) {
        this.requestedAt = requestedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
