package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.AccessTokenDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.OrderDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestTokenDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.provider.JwtService;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserPortIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Generate Token Controller", description = "Controller for create access token for use in other routes")
public class CreateTokenRestController {

    private final GetUserPortIn getUserPortIn;
    private final JwtService jwtService;

    @PostMapping(path = "/api/v1/auth")
    @Operation(summary = "Generate access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully token generated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AccessTokenDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized access")
    })
    public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                                    @RequestBody RequestTokenDto body) {

        var user = getUserPortIn.getUser(body.getUsername(), body.getPassword());

        return user
                .map(value -> ResponseEntity
                        .ok(AccessTokenDto
                                .builder()
                                .withToken(jwtService.generateToken(value.getUsername()))
                                .build()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());


    }

}
