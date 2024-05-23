package com.aquiteturahexa.techchallenge.core.model;

import java.util.regex.Pattern;

public class Email {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);
    private final String email;

    public Email(String email) {
        if (!PATTERN.matcher(email).matches()) {
            throw new RuntimeException("Email is not valid");
        }

        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
