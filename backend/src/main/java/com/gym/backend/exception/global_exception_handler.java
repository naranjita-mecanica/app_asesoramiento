package com.gym.backend.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class global_exception_handler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlderMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          WebRequest webRequest) {
        String mensaje = exception.getBindingResult().getFieldError().getDefaultMessage();
        return new ResponseEntity<Object>(mensaje, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handlderRuntimEntity(RuntimeException exception,
                                                                          WebRequest webRequest) {
        String mensaje = exception.getMessage();
        return new ResponseEntity<Object>(mensaje, HttpStatus.BAD_REQUEST);
    }
}
