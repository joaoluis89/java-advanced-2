package com.example.demo.domains.exceptions;

public class AlunoNotFoundException extends ResourceNotFoundException {
    public AlunoNotFoundException(String message) {
        super(message);
    }
}
