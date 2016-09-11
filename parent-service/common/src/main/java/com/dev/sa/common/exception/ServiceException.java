package com.dev.sa.common.exception;

/**
 * Created by Anie on 1/16/2016.
 */
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }

    public ServiceException(final String message) {
        super(message);
    }

    public ServiceException(final Throwable cause) {
        super(cause);
    }

    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
