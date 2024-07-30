package com.cleanarchitecture.techchallenge.application.gateways;

public interface EncodePasswordGateway {

    String encode(String password);

    boolean matches(String password, String encodedPassword);
}
