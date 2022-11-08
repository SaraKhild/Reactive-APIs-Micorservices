package com.moviereview.moviereview.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.moviereview.moviereview.exceptions.MovieReviewNotFoundException;
import com.moviereview.moviereview.models.MovieReview;
import com.moviereview.moviereview.repositories.MovieReviewRepository;

import reactor.core.publisher.Mono;

@Component
public class MovieReviewHandler {

    @Autowired
    private MovieReviewRepository repository;

    public Mono<ServerResponse> add(ServerRequest request) {

        return request.bodyToMono(MovieReview.class)
                .flatMap(model -> {
                    return repository.save(model)
                            .flatMap(save -> {
                                return ServerResponse.status(HttpStatus.CREATED)
                                        .bodyValue(save);
                            });
                });
    }

    public Mono<ServerResponse> get(ServerRequest request) {

        var movieInfoId = request.queryParam("movieInfoId");
        if (movieInfoId.isPresent()) {
            var flux = repository.findReviewByMovieInfoId(Long.valueOf(movieInfoId.get()));
            return ServerResponse.ok().body(flux, MovieReview.class);
        } else {
            var flux = repository.findAll();
            return ServerResponse.ok().body(flux, MovieReview.class);
        }
    }

    public Mono<ServerResponse> update(ServerRequest request) {

        var id = request.pathVariable("id");
        var isExisting = repository.findById(id)
                .switchIfEmpty(Mono.error(new MovieReviewNotFoundException("Movie Review not found for the given id"+ id)));

        return isExisting.flatMap(review -> request.bodyToMono(MovieReview.class)
                .map(update -> {

                    review.setComment(update.getComment());
                    return review;
                })
                .flatMap(repository::save)
                .flatMap(x -> ServerResponse.ok().bodyValue(x)));

    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        var id = request.pathVariable("id");
        var isExisting = repository.findById(id);

        return isExisting.flatMap(review -> repository.deleteById(id)
                .then(ServerResponse.noContent().build()));

    }

}
