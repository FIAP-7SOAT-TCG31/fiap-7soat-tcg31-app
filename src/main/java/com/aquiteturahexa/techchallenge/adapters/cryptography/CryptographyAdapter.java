package com.aquiteturahexa.techchallenge.adapters.cryptography;

import com.aquiteturahexa.techchallenge.core.ports.in.EncodePasswordPortOut;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CryptographyAdapter implements EncodePasswordPortOut {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean matches(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
