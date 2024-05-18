package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestTokenDto;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AutenticateController {

    private final GetUserPortIn getUserPortIn;

    @PostMapping(path = "/auth")
    public ResponseEntity<?> create(@RequestBody RequestTokenDto body) {

        var user = getUserPortIn.getUser(body.getUsername(), body.getPassword());

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Authentication failed"));
        }

    return ResponseEntity
            .ok(
                    Map.of("token", "generateToken(user.get())")
            );
    }
}
