package de.vando.snakeworld.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class HighscoreAlreadyExistsException extends RuntimeException {
    public HighscoreAlreadyExistsException(String message) {
        super(message);
    }
}
