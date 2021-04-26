package com.example.thymeleavfsse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ControllerToRest {

    @GetMapping(value="/rest/fizzbuzz", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> integers(){
        return FizzBuzzFluxGenerator.createFlux();
    }
}
