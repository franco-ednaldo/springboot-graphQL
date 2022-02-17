package com.example.compras.graphQL.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
