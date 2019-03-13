package com.stackroute.movieservice.exception;

/*Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a com.stack....exceptions package.
 Perform appropriate exception handling and propagation back.*/

public class MovieAlreadyExistsException extends Exception {
    private String message;
    public MovieAlreadyExistsException(){}
    public MovieAlreadyExistsException(String message){
        super(message);
        this.message =message;
    }
}
