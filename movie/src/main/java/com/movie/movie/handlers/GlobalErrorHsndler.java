package com.movie.movie.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.movie.movie.exceptions.MovieInfoClientException;


@ControllerAdvice // use @ControllerAdvice annotation to manage exceptions in a Spring Boot
                  // application.
public class GlobalErrorHsndler { // this for handling for client

    @ExceptionHandler(MovieInfoClientException.class)
    public ResponseEntity<String> handlerClientException(MovieInfoClientException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class) // general exception 
    public ResponseEntity<String> handleRunTimeException(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }


    // 1- the resaone for hanlde is show for client  and also must handle enpoint in MovieInfo controller 
   //  2- design the microServcie  - client , defintion
  //   3- webclient .build  @Autowired, webclient . create 
 //    4- webclient is integration used in webflux
//     5- Tomcate server , Netty server 
//     6- microService
   
}
