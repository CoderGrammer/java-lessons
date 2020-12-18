package com.lessons.optional;

import java.util.Optional;

public class _15_IsPresentIsEmpty {

    public static void main(String[] args) {
        Optional<Integer> o = Optional.of(1);
        print(o.isPresent()); // True
        print(o.isEmpty()); // False - Only added in Java 11!
    }

}
