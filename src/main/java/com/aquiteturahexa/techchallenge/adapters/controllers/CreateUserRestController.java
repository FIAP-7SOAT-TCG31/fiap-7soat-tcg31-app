package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.AccessTokenDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateUserDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.UserDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.UserMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateUserPortIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Create User Controller", description = "Controller for receiving user data and save it in the database")
public class CreateUserRestController {

    private final CreateUserPortIn createUserPortIn;

    @PostMapping(path = "/api/v1/users")
    @Operation(summary = "Create item data")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Receive user data and save it in the database",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class)))
    })
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
