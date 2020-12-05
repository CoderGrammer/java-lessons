package com.lessons.optional;

import java.util.Optional;

public class _5_What {

    public static void main(String[] args) {

        Optional<String> s = Optional.empty();

        System.out.println(meth()
                                   .map(String::length)
                                   .orElse(0));
    }

    static Optional<String> meth() {
        return Optional.ofNullable(null);
    }

}
