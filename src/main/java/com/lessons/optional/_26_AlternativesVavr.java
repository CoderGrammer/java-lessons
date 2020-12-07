package com.lessons.optional;

import io.vavr.control.Option;

import java.util.Optional;

/*
 - It is an interface
 - It has two implementations/concrete types; Some and None
 - It is Serializable
 - Another key diff if that in java a .map that results in null returns Optional.empty(), in vavr it would be Some(null)
 - This can cause NPEs in VAVR
*/
public class _26_AlternativesVavr {

    public static void main(String[] args) {
        Option<Integer> o = Option.of(1);
    }

    /*
     - The anomaly is that it it allows Some(null) whereas Optional Present with null is not possible
     */
    void throwsNPE() {
        Option.of(1)
                .map(i -> (String) null) // Maps to Some(null) - but in Javas Optional this would be Empty Optional
                .map(String::intern); // Promptly throws a NPE!

        // Is this a problem? Well yes but there is a better approach in VAVR:
        Option.of(1)
                .map(i -> (String) null)
                .flatMap(s -> Option.of(s).map(String::intern)); // Note Option.of is None in this case

        /*
         - Why is this better?
         - Well it is more appropriate behaviour of a monad
         - The key is that the map method should not change the computational context
         - This is what happens with:
        */
        Optional.of("a")
                .map(s -> (String) null) // Computational context changes here to Empty
                .map(String::toUpperCase);

        // In actual fact flatMap should be used for context changes as in the VAVR Option case
    }


}
