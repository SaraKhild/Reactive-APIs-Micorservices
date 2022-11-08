package com.movie.movie.models;




import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private MovieInfo movieInfo;
   private List<MovieReview> MovieReviewm;
    
}
