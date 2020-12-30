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

        /*
         - Pass in a consumer
         - Its ignored if not present
         - One more advantage - lambdas are lazy
         - Only evaluated if needed
        */
        o.ifPresent(op -> print(op));
        o.ifPresent(System.out::println);
    }

    /*
     - Questions:
         - 1. What type of function does ifPresent take?
         - 2. If present should be avoided and alternatives should be used. True/False
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
