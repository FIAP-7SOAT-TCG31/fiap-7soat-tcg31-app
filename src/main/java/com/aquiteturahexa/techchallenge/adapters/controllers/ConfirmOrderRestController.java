package com.aquiteturahexa.techchallenge.adapters.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ConfirmOrderRestController {

    @PostMapping(path = "/api/v1/orders/{id}/payment")
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers) {
        return null;
    }

}
