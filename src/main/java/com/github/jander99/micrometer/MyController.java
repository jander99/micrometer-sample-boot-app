package com.github.jander99.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class MyController {

    private CommentService commentService;

    private final MeterRegistry registry;

    public MyController(@Autowired CommentService commentService, @Autowired MeterRegistry registry) {
        this.commentService = commentService;
        this.registry = registry;
    }

    @GetMapping("/hi")
    private Mono<String> hello() {

        return registry.timer("v1", "hello", "timer").record(() ->
                Mono.just("Hello")
        );
    }

    @GetMapping("/comments")
    private Flux<Comment> getComments() {

        return registry.timer("v1", "comments", "timer").record(() ->
                commentService.getAllComments()
        );
    }

}
