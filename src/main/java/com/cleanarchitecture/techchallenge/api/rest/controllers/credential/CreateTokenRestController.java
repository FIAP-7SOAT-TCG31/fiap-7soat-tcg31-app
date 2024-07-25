package com.cleanarchitecture.techchallenge.api.rest.controllers.credential;

import com.cleanarchitecture.techchallenge.api.rest.dtos.credential.AccessTokenDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.credential.RequestTokenDto;
import com.cleanarchitecture.techchallenge.api.rest.provider.JwtService;
import com.cleanarchitecture.techchallenge.domain.usecases.GetUserUseCase;
import com.cleanarchitecture.techchallenge.infra.controllers.credential.CreateTokenController;
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

    private final CreateTokenController createTokenController;

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

        var accessToken = createTokenController.create(body);

        return accessToken == null
                ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
                : ResponseEntity.ok(accessToken);
    }

}
