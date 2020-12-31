package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - Also more functional... but catering to both scenarios, Empty and Present
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
         - 1. You should never ever call ifPresentOrElse without calling isPresent
           first. True/False
            - False. Its not needed since it is a 'safe' method
         - 2. ifPresentOrElse takes two consumers, one for present and one for absent.
           True/False
            - False. It takes a consumer (for present) and a runnable (for empty)
    */

}

