package com.coffeemachine;

public class MissingMoneyException extends Exception {
    public MissingMoneyException(String message) {
        super(message);
    }
}
