package de.vando.snakeworld.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> ExceptionHandler(Exception e, WebRequest request){
        ExceptionDetails details = new ExceptionDetails(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HighscoreAlreadyExistsException.class)
    public ResponseEntity<?> HighscoreAlreadyExistsExceptionHandler(HighscoreAlreadyExistsException e, WebRequest request){
        ExceptionDetails details = new ExceptionDetails(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(details, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HighscoreNotFoundException.class)
    public ResponseEntity<?> HighscoreNotFoundExceptionHandler(HighscoreNotFoundException e, WebRequest request){
        ExceptionDetails details = new ExceptionDetails(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
}
