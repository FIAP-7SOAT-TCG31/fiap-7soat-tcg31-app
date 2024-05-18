package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.core.ports.in.GetUserByDocumentPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GetUserByDocumentRestController {

    private final GetUserByDocumentPortIn getUserByDocumentPortIn;

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @RequestParam("cpf") String cpf) {

        var user = getUserByDocumentPortIn.find(cpf);

        return user.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(user);
    }

}
