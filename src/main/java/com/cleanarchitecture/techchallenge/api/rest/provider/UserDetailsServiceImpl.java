package com.cleanarchitecture.techchallenge.api.rest.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String[] tokenParts = username.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(tokenParts[1]));
        JSONObject jsonObject = new JSONObject(payload);

        try {
            if (StringUtils.isBlank(jsonObject.getString("custom:cpf"))) {
                throw new BadCredentialsException("Token not valid");
            }
        } catch (Exception e) {
            return new User(
                    "ERROR",
                    "ERROR",
                    new HashSet<>());
        }

        return new User(
                jsonObject.getString("custom:cpf"),
                jsonObject.getString("sub"),
                Set.of(new SimpleGrantedAuthority(jsonObject.getString("custom:role").toUpperCase())));
    }
}
