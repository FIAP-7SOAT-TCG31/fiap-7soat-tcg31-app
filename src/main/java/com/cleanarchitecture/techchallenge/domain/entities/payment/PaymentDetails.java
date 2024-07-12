package com.cleanarchitecture.techchallenge.domain.entities.payment;

public class PaymentDetails {

    private final String key;
    private final String value;

    public PaymentDetails(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
