import java.time.Duration;
import java.util.Arrays;

import reactor.core.publisher.Flux;

public class CodeChallenge1 {
    public static void main(String[] args) {

        Flux<String> empty = emptyFlux();
        empty.subscribe(System.out::println);
        Flux<String> values = fooBarFluxFromValues();
        values.subscribe(System.out::println);
        Flux<String> list = fooBarFluxFromList();
        list.subscribe(System.out::println);
        Flux<String> error = errorFlux();
        error.subscribe(System.out::println, System.err::println);

        Flux<Long> counter = counter();
        counter.subscribe(System.out::println);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // TODO Return an empty Flux
    static Flux<String> emptyFlux() {
        return Flux.empty();
    }

    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    static Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    static Flux<String> fooBarFluxFromList() {
        return Flux.fromIterable(Arrays.asList("foo", "bar"));
    }

    // TODO Create a Flux that emits an IllegalStateException
    static Flux<String> errorFlux() {
        return Flux.error(new IllegalStateException());
    }

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    static Flux<Long> counter() {
        return Flux.interval(Duration.ofMillis(100)).take(10);
    }
}
