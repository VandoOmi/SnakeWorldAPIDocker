package de.vando.snakeworld.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HighscoreNotFoundException extends RuntimeException {
    public HighscoreNotFoundException(String message) {
        super(message);
    }
}
