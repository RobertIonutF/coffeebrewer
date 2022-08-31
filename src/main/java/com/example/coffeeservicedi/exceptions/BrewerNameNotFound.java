package com.example.coffeeservicedi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Brewer not found")
public class BrewerNameNotFound extends Exception {
    public BrewerNameNotFound(String message) {
        super(message);
    }
}
