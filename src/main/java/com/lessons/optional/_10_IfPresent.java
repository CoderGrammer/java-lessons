package com.lessons.optional;

import java.util.Optional;

/*
 - A little more functional...
*/
public class _10_IfPresent {
    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");
        o.ifPresent(op -> System.out.println(op));
        o.ifPresent(System.out::println);
    }
}
