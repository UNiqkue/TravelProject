package com.netcracker.travel.exception;

public class UsernameExistException extends RuntimeException {

    public UsernameExistException() {
        super("User with such username exists");
    }

}
