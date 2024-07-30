package com.cleanarchitecture.techchallenge.application.exceptions;

public class PaymentNotGeneratedException extends RuntimeException {

    public PaymentNotGeneratedException(Throwable cause, String message) {
        super(message, cause);
    }
}
