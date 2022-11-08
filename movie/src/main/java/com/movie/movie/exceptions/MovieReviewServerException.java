package com.movie.movie.exceptions;

public class MovieReviewServerException extends RuntimeException {

    private String message;

    public MovieReviewServerException(String message) {
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
