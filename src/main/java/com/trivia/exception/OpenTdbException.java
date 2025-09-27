package com.trivia.exception;

public class OpenTdbException extends RuntimeException {
    public OpenTdbException(String message) {
        super(message);
    }
    public OpenTdbException(String message, Throwable cause) {
        super(message, cause);
    }
}
