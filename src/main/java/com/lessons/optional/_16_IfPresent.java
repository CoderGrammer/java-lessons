package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - Example little more functional...
*/
public class _16_IfPresent {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");

        if (o.isPresent()) {
            print(o.get());
        }

        o.ifPresent(op -> print(op));
        o.ifPresent(System.out::println);
    }

}
