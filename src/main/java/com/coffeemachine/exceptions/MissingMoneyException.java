package com.coffeemachine.exceptions;

public class MissingMoneyException extends Exception {
    public MissingMoneyException(String message) {
        super(message);
    }
}
