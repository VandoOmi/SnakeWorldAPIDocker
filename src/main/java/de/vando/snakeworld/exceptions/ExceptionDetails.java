package de.vando.snakeworld.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor

public class ExceptionDetails {
    private String message;
    private String details;
    private Date timestamp;
}
