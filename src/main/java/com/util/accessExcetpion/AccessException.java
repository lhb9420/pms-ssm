package com.util.accessExcetpion;

public class AccessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccessException(String message) {
        super(message);
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessException(Throwable cause) {
        super(cause);
    }
}
