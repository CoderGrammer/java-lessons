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

    /*
     - Questions:
         - 1. You should never ever call ifPresentOrElse without calling isPresent
           first. True/False
         - 2. ifPresentOrElse takes two consumers, one for present and one for absent.
           True/False
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

