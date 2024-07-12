package com.cleanarchitecture.techchallenge.domain.entities.payment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Payment {

    private final String id;
    private final String type;
    private Boolean isPaid;
    private Instant paidAt;
    private List<PaymentDetails> paymentDetails;

    public Payment(String id,
                   String type,
                   List<PaymentDetails> paymentDetails,
                   Boolean isPaid,
                   Instant paidAt) {
        this.id = id;
        this.type = type;
        this.paymentDetails = paymentDetails;
        this.isPaid = isPaid;
        this.paidAt = paidAt;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public Instant getPaidAt() {
        return paidAt;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void addPaymentDetails(String key, String value) {
        if (paymentDetails == null) {
            this.paymentDetails = new ArrayList<>();
        }

        this.paymentDetails.add(new PaymentDetails(key, value));
    }

    public void setPaid(Instant paidAt) {
        this.isPaid = true;
        this.paidAt = paidAt;
    }
}
