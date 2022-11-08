package com.movie.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.Client.MovieInfoRestClient;
import com.movie.movie.Client.MovieReviewRestClient;
import com.movie.movie.models.Movie;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieInfoRestClient movieInfoRestClient;
    @Autowired
    private MovieReviewRestClient movieReviewRestClient;
    

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id){

        return movieInfoRestClient.getMovieInfo(id).flatMap(movieInfo->{

            var movieReviewList = movieReviewRestClient.getMovieReview(id).collectList();

            return movieReviewList.map(movieReview -> new Movie(movieInfo, movieReview));
        });

    }
    
    
}
