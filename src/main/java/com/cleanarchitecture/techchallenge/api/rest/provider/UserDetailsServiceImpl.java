package com.cleanarchitecture.techchallenge.api.rest.provider;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import com.cleanarchitecture.techchallenge.domain.usecases.GetUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GetUserUseCase getUserUseCase;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = getUserUseCase.getUser(username)
                .orElseThrow((() -> new UsernameNotFoundException("User not exists!")));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user
                        .getRoles()
                        .stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList()
        );
    }
}
