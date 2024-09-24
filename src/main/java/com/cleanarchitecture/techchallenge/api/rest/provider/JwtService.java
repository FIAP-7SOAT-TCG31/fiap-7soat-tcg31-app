package com.cleanarchitecture.techchallenge.api.rest.provider;

import org.springframework.stereotype.Component;

@Component
public class JwtService {


    public Boolean validateToken(String token) {
        return token != null;
    }


}
