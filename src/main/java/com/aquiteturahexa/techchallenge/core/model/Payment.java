package com.aquiteturahexa.techchallenge.core.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Payment {

    private final String type;
    private final Order order;
    private Map<String, String> paymentDetails;

    public Payment(String type, Order order, Map<String, String> paymentDetails) {
        this.type = type;
        this.order = order;
        this.paymentDetails = paymentDetails;
    }

    public String getType() {
        return type;
    }

    public Order getOrder() {
        return order;
    }

    public Map<String, String> getPaymentDetails() {
        return paymentDetails;
    }

    public void addPaymentDetails(String key, String value) {
        if (paymentDetails == null) {
            this.paymentDetails = new HashMap<>();
        }

        this.paymentDetails.put(key, value);
    }
}
