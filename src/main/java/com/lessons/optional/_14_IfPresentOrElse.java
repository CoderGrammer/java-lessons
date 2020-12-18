package com.lessons.optional;

import java.util.Optional;

/*
 - Example little more functional... but catering to both scenarios, Empty and Present
*/
public class _14_IfPresentOrElse {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");
        o.ifPresentOrElse(
                g -> print(g.toUpperCase()), // If Present
                () -> print("xyz")); // Or Else If Empty
    }

}
