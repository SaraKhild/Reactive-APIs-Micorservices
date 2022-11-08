package com.movie.movie.exceptions;

public class MovieInfoServerException extends RuntimeException {

    private String message;

    public MovieInfoServerException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
