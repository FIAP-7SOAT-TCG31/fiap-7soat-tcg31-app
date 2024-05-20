package com.aquiteturahexa.techchallenge.core.ports.in;

public interface EncodePasswordPortOut {

    String encode(String password);

    boolean matches(String password, String encodedPassword);
}
