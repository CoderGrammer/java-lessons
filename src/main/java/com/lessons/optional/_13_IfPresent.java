package com.lessons.optional;

import java.util.Optional;

/*
 - Example little more functional...
*/
public class _13_IfPresent {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");
        o.ifPresent(op -> print(op));
        o.ifPresent(System.out::println);
    }

}
