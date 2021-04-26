package com.example.thymeleavfsse;

import reactor.core.publisher.Flux;

import java.time.Duration;

import java.util.concurrent.atomic.AtomicLong;


public class FizzBuzzFluxGenerator {

    public static Flux<String> createFlux(){
        var counter = new AtomicLong();
        return Flux.interval(Duration.ofMillis(1000))
                .map(i -> counter.incrementAndGet())
                .map(i -> i % 5 == 0 ? (i % 7 == 0 ? "FizzBuzz" : "Fizz") : (i % 7 == 0 ? "Buzz" : i.toString()));
    }

}
