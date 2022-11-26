package com.example.musicplayer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ArtistNameTakenException extends RuntimeException {
    public ArtistNameTakenException(String message) {
        super(message);
    }
}
