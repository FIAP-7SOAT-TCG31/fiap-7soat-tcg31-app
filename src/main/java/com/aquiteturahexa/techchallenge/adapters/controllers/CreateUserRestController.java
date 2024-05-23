package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateUserDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.UserMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateUserPortIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CreateUserRestController {

        private final CreateUserPortIn createUserPortIn;

        @PostMapping(path = "/api/v1/users")
        public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                        @RequestBody RequestCreateUserDto body) {

                var user = UserMapper.toDomain(body.getUser());
                createUserPortIn.create(user);

                final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(user.getUsername())
                                .toUri();

                return ResponseEntity
                                .created(location)
                                .body(UserMapper.toDto(user));
        }

}
