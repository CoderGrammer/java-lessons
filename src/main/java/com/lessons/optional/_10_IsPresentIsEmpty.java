package com.lessons.optional;

import java.util.Optional;

public class _10_IsPresentIsEmpty {

    public static void main(String[] args) {
        Optional<Integer> o = Optional.of(1);
        System.out.println(o.isPresent()); // True
        System.out.println(o.isEmpty()); // False - Only added in Java 11!
    }

}
