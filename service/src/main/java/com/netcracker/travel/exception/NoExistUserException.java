package com.netcracker.travel.exception;

public class NoExistUserException extends RuntimeException {

    public NoExistUserException() {
        super("You can't register (invalid username, email or other user data)");
    }

}
