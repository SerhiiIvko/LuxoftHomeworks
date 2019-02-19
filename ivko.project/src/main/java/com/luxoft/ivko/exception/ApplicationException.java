package com.luxoft.ivko.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException(){}

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}