package com.lessons.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.lessons.optional._99_Utils.print;

/*
 - A little more functional...
 - Functions/lambdas in java are pieces of code that can be passed around to be
   executed later if/when required
    - Function<T, R>
    - Consumer<T>
    - Supplier<T>
    - Predicate<T>
*/
public class _16_IfPresent {

    public static void main(String[] args) {
        Optional<String> o = Optional.of("abc");

        if (o.isPresent()) {
            print(o.get());
        }

        /*
         - Pass in a consumer
         - Its ignored if not present
         - One more advantage - lambdas are lazy
         - Only evaluated if needed
        */
        o.ifPresent(op -> print(op));
        o.ifPresent(System.out::println); // Method reference
    }

    /*
     - Questions:
         - 1. What type of function does ifPresent take?
         - 2. ifPresent should be avoided and alternatives should be used. True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. What type of function does ifPresent take?
             - A consumer
         - 2. If present should be avoided and alternatives should be used. True/False
             - False. Its perfectly reasonable if you want some side effect if a value
               is present
    */

}
