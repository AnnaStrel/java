package ru.sgu.presentation.bank.error;

public class AccountExistsException extends RuntimeException {

    public AccountExistsException(String message) {
        super(message);
    }

}
