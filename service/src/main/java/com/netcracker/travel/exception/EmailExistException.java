package com.netcracker.travel.exception;

public class EmailExistException extends RuntimeException {

    public EmailExistException() {
        super("User with such email exists");
    }

}
