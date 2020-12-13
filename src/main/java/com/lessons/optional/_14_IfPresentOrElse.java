package com.lessons.optional;

import java.util.Optional;

/*
 - A little more functional... but catering to both scenarios, Empty and Present
*/
public class _14_IfPresentOrElse {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");
        o.ifPresentOrElse(
                g -> System.out.println(g.toUpperCase()), // If Present
                () -> System.out.println("xyz")); // Or Else If Empty
    }

}
