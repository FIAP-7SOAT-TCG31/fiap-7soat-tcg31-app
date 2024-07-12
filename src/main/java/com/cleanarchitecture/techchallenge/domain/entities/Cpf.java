package com.cleanarchitecture.techchallenge.domain.entities;

public record Cpf(String number) {
    public Cpf {
        if (!validate(number)) {
            throw new RuntimeException("Document number is not valid");
        }
    }

    private boolean validate(String cpf) {

        if (cpf == null || cpf.length() < 11) {
            return false;
        }

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit > 9) {
            firstDigit = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit > 9) {
            secondDigit = 0;
        }

        return Character.getNumericValue(cpf.charAt(9)) == firstDigit && Character.getNumericValue(cpf.charAt(10)) == secondDigit;
    }
}
