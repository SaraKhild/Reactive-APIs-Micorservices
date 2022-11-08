package com.movie.movie.Client;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.movie.exceptions.MovieInfoClientException;
import com.movie.movie.exceptions.MovieInfoServerException;
import com.movie.movie.models.MovieInfo;

import reactor.core.publisher.Mono;

@Component
public class MovieInfoRestClient {

        // @Autowired
        // private WebClient webClient;
        private WebClient webClient = WebClient.builder().build(); 
        
        // there is another way by using @Value()
        private String movieInfoUrl = "http://localhost:8080/movies-information/";

        public Mono<MovieInfo> getMovieInfo(String id) {

                return this.webClient.get()
                                .uri(movieInfoUrl + "get-movie-info-by-id/" + id)
                                .retrieve()
                                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                                        return Mono.error(new MovieInfoClientException(
                                                        "There is no Movie info for this id:" + id,
                                                        clientResponse.statusCode().value()));
                                })
                                // this is another way wrting code
                                // if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)){
                                // return Mono.error(new MovieInfoClientException(
                                // "There is no Movie info for this id:" + id,
                                // clientResponse.statusCode().value()));
                                // }
                                // return clientResponse.bodyToMono(String.class)
                                // .flatMap(responseMessage -> Mono.error(new MovieInfoClientException(
                                // responseMessage, clientResponse.statusCode().value())));

                                // })

                                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {

                                        return clientResponse.bodyToMono(String.class)
                                                        .flatMap(responseMessage -> Mono
                                                                        .error(new MovieInfoServerException(
                                                                                        "Server Exception"
                                                                                                        + responseMessage)));

                                })

                                .bodyToMono(MovieInfo.class);
        }

}
