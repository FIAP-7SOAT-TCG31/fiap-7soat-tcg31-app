package com.cleanarchitecture.techchallenge.application.exceptions;

public class OrderCannotBeUpdatedException extends RuntimeException {

    public OrderCannotBeUpdatedException(String message) {
        super(message);
    }
}