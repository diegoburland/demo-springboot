package com.learning.academy.exception;

public class NameAlreadyExistsException extends RuntimeException{
    public NameAlreadyExistsException(String message) {
        super(message);
    }
}
