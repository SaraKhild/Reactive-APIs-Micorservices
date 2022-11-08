package com.movie.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.movie.movie.models.Movie;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // this annotation  create random port testing
@AutoConfigureWebTestClient  // is used to configure the reactive WebClient of Spring WebFlux.
@AutoConfigureWireMock(port = 8084) //  Stubbing up a httpserver in port 8084
@TestPropertySource( // put the urls
    properties = {"http://localhost:8084/movies-information",
                  "http://localhost:8084/get"
                 }
)
public class MovieControllerIntgTest {

    @Autowired
    private WebTestClient webclient;

    @Test
    void retrieveMovieById() {

        var id = "1";
        stubFor(get(urlEqualTo("/movies-information"+"/"+id))
        .willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withBodyFile("movieInfo.json")));

        stubFor(get(urlPathEqualTo("/get"))
        .willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withBodyFile("reviewMovie.json")));

        

        webclient
                .get()
                .uri("/movie/{id}", id)
                .exchange()
               .expectStatus().isOk()
               .expectBody(Movie.class);

        
    }
    
    
    
}
