package com.learning.academy.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
