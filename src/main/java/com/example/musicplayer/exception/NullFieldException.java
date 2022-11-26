package com.example.musicplayer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LENGTH_REQUIRED)
public class NullFieldException extends RuntimeException {
    public NullFieldException(String message) {
        super(message);
    }
}
