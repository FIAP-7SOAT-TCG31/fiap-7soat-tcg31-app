package com.aquiteturahexa.techchallenge.adapters.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AdvanceStatusRestController {

    @PatchMapping(path = "/api/v1/orders/{id}/status")
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers) {
        return null;
    }
}
