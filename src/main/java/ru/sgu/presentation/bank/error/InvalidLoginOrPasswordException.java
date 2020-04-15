package ru.sgu.presentation.bank.error;

public class InvalidLoginOrPasswordException extends RuntimeException {

    public InvalidLoginOrPasswordException(String message) {
        super(message);
    }

}
