package com.cleanarchitecture.techchallenge.domain.entities.order;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

import java.math.BigDecimal;
import java.time.Instant;

public class Order {

    private Long id;
    private Client requester;
    private Combo combo;
    private Instant requestedAt;
    private Instant updatedAt;
    private BigDecimal amount;
    private Status status;
    private Payment payment;

    public Order(Long id,
                 Client requester,
                 Combo combo,
                 Instant requestedAt,
                 Instant updatedAt,
                 BigDecimal amount,
                 Status status,
                 Payment payment) {
        this.id = id;
        this.requester = requester;
        this.requestedAt = requestedAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.payment = payment;
        updateCombo(combo);
    }

    public Long getId() {
        return id;
    }

    public Client getRequester() {
        return requester;
    }

    public Combo getCombo() {
        return combo;
    }

    public Instant getRequestedAt() {
        return requestedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void updateCombo(Combo combo) {
        this.combo = combo;
        this.amount = combo == null ? BigDecimal.ZERO : combo.calculate();
    }

    public void advance() {
        this.status = this.status.advance();
        this.updatedAt = Instant.now();
    }

    public void cancel() {
        this.status = Status.CANCELLED;
        this.updatedAt = Instant.now();
    }
}
