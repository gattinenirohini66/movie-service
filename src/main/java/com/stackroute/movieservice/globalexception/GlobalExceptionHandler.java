package com.stackroute.movieservice.globalexception;

import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // any exception comes here when it was thrown
public class GlobalExceptionHandler {
    // this are my exception clases
    @ExceptionHandler({MovieAlreadyExistsException.class, MovieNotFoundException.class})
    public ResponseEntity<String> handleMoviealreadyExistException(Exception e) {
        return new ResponseEntity<String>("Global Exception thrown here " + e.getMessage(), HttpStatus.CONFLICT);
    }
}
