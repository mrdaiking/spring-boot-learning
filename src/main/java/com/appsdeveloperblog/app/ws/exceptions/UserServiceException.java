package com.appsdeveloperblog.app.ws.exceptions;

public class UserServiceException extends RuntimeException {
    private static final long serialVersionUID = 13243567655675L;

    public UserServiceException(String message) {
        super(message);
    }
}
