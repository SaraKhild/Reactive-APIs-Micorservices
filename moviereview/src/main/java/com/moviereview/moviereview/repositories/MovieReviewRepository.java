package com.moviereview.moviereview.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.moviereview.moviereview.models.MovieReview;

import reactor.core.publisher.Flux;

public interface MovieReviewRepository extends ReactiveMongoRepository<MovieReview, String> {

    Flux<MovieReview> findReviewByMovieInfoId(Long MovieInfoId);

}
