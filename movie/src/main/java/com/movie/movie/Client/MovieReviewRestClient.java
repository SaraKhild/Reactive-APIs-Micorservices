package com.movie.movie.Client;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.movie.movie.exceptions.MovieReviewServerException;
import com.movie.movie.models.MovieReview;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieReviewRestClient {

    // @Autowired
    // private WebClient webClient;
    private WebClient webClient = WebClient.builder().build();
    // there is another way by using @Value()
    private String movieReviewUrl = "http://localhost:8081/get";

    public Flux<MovieReview> getMovieReview(String id) {

        var url = UriComponentsBuilder.fromHttpUrl(movieReviewUrl)
                .queryParam("movieInfoId", id)
                .buildAndExpand().toUriString();
        return this.webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    return Mono.empty();
           

                })
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {

                    return clientResponse.bodyToMono(String.class)
                            .flatMap(responseMessage -> Mono.error(new MovieReviewServerException("Server Exception" +responseMessage)));

                })
                .bodyToFlux(MovieReview.class);
    }

}
