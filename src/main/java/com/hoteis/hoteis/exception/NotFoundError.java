package com.hoteis.hoteis.exception;

public class NotFoundError extends RuntimeException {
    public NotFoundError(String error){
        super(error);
    }
}
