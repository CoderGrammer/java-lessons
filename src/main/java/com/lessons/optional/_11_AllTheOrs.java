package com.lessons.optional;

import java.util.Optional;

public class _11_AllTheOrs {

    // or
    void or() {
        Optional<Integer> o = Optional.of(1);
        Optional<Integer> or = o.or(() -> Optional.of(2));
        // Use this when you want to return an Optional and you have something that yields an alternative Optional
    }

    // orElse
    void orElse() {
        Optional<Integer> o = Optional.of(1);
        Integer i = o.orElse(2);
        // Use this when you want to return a value that is not wrapped in an Optional but have an alternate value too

        // What if you actually want a null?
        o.orElse(null);
    }

    // orElseGet
    void orElseGet() {
        Optional<Integer> o = Optional.of(1);
        Integer integer = o.orElseGet(() -> 2);
        // Use this instead of orElse when:
        // you want to return a value that is not wrapped in an Optional but have an alternate value too
        // ...but it is expensive to compute
    }

    // orElseThrow
    // These methods can be used for 'defensive coding'
    void orElseThrow() {
        Optional<Integer> o = Optional.of(1);
        Integer integer = o.orElseThrow(); // Throws a NoSuchElementException if empty!
        // Use this when an absence of a value i.e. an empty Optional indicates an error
    }

    // orElseThrow
    void orElseThrow2() {
        Optional<Integer> o = Optional.of(1);
        Integer integer = o.orElseThrow(() -> new IllegalStateException("Whoops!"));
        Integer integer2 = o.orElseThrow(IllegalStateException::new);
        // Use this when an absence of a value i.e. an empty Optional indicates an error
        // ...but you want a specific exception, even more so if it is expensive to construct
    }

    void goingOverMultipleOptionals() {
        var first = Optional.empty();
        var second = Optional.empty();
        var third = Optional.empty();

        // Map is no good in this case because it is about transforming a value that is present
        // first.map()

        // Or is the method to use
        first.or(() -> second)
                .or(() -> third)
                    .orElse("something");
        // or returns an optional whereas orElse orElseGet return values
    }

}
