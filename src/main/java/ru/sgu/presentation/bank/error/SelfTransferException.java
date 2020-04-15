package ru.sgu.presentation.bank.error;

public class SelfTransferException extends RuntimeException {

    public SelfTransferException(String message) {
        super(message);
    }

}
