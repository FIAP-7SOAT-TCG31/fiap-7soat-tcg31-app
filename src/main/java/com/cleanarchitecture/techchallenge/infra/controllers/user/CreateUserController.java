package com.cleanarchitecture.techchallenge.infra.controllers.user;

import com.cleanarchitecture.techchallenge.api.rest.dtos.user.RequestCreateUserDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.user.UserDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateUserUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.user.UserPresenter;
import org.springframework.stereotype.Component;

@Component
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserPresenter userPresenter;

    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.userPresenter = UserPresenter.getInstance();
    }

    public UserDto create(RequestCreateUserDto body) {

        var user = userPresenter.toDomain(body.getUser());
        createUserUseCase.create(user);
        return userPresenter.toDto(user);
    }

}
