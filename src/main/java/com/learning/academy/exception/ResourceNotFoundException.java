package com.learning.academy.exception;

public class ResourceNotFoundException extends RuntimeException{

        public ResourceNotFoundException(String message) {
            super(message);
        }
}
