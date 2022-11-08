package com.movie.movie.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieReview {
    private String reviewId;
    private Long movieInfoId;
    private String comment;
    private Double rating;
    
}
