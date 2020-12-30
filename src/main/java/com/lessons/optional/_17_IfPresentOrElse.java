package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - Example little more functional... but catering to both scenarios, Empty and Present
*/
public class _17_IfPresentOrElse {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");

        if (o.isPresent()) {
            print(o.get().toUpperCase());
        } else {
            print("xyz");
        }

        // This replaces the above... but its even better... as lambdas are lazy
        o.ifPresentOrElse(
                g -> print(g.toUpperCase()), // If Present
                () -> print("xyz")); // Or Else If Empty
    }

}
