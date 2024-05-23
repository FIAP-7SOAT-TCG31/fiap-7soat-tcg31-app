package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByDocumentPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GetClientByDocumentRestController {

    private final GetClientByDocumentPortIn getClientByDocumentPortIn;

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @RequestParam("cpf") String cpf) {

        var client = getClientByDocumentPortIn.find(cpf);

        return client.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(client);
    }

}
