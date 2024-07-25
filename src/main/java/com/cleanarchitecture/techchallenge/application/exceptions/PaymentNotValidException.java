package com.cleanarchitecture.techchallenge.application.exceptions;

public class PaymentNotValidException extends RuntimeException {

    public PaymentNotValidException(String message) {
        super(message);
    }
}
