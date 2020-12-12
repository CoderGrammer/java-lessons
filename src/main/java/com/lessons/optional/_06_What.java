package com.lessons.optional;

import java.util.Optional;

/*
 - A container object which may or may not contain a non-null value
 - If a value is present, it is called present
 - If not, it is called empty (or absent)
*/
public class _06_What {

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
