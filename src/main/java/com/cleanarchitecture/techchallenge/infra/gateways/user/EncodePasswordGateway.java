package com.cleanarchitecture.techchallenge.infra.gateways.user;

public interface EncodePasswordGateway {

    String encode(String password);

    boolean matches(String password, String encodedPassword);
}
