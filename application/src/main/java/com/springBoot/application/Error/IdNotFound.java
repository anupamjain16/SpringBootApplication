package com.springBoot.application.Error;

public class IdNotFound extends Exception
{
    public IdNotFound() {
        super();
    }

    public IdNotFound(String message) {
        super(message);
    }

    public IdNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public IdNotFound(Throwable cause) {
        super(cause);
    }

    protected IdNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
