package com.cleanarchitecture.techchallenge.domain.entities;

import java.util.regex.Pattern;

public record Email(String email) {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public Email {
        if (!PATTERN.matcher(email).matches()) {
            throw new RuntimeException("Email is not valid");
        }

    }
}
