package com.netcracker.travel.exception;

public class UnnecessaryActionException extends RuntimeException {
    public UnnecessaryActionException() {
        super();
    }

    public UnnecessaryActionException(String message) {
        super(message);
    }
}
