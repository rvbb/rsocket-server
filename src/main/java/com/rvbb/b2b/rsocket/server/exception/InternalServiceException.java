package com.rvbb.b2b.rsocket.server.exception;

public class InternalServiceException extends RuntimeException {
    public InternalServiceException(String message) {
        super(message);
    }
}
