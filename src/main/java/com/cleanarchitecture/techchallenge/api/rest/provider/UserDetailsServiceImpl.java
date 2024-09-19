package com.cleanarchitecture.techchallenge.api.rest.provider;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] tokenParts = username.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(tokenParts[1]));
        JSONObject jsonObject = new JSONObject(payload);
        return new User(jsonObject.getString("custom:cpf"), jsonObject.getString("custom:cpf"), List.of(new SimpleGrantedAuthority(jsonObject.getString("custom:role"))));
    }
}
