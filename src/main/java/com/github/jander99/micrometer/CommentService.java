package com.github.jander99.micrometer;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CommentService {

    Flux<Comment> getAllComments() {

        WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");
        return client.get()
                .uri("/comments")
                .retrieve()
                .bodyToFlux(Comment.class);
    }
}
