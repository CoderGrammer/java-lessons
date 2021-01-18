package com.lessons.optional;

import io.vavr.control.Option;

import java.util.Optional;

/*
 - It is an interface
 - It has two implementations/concrete types; Some and None
 - It is Serializable
 - Another key diff if that in Java a .map that results in null returns Optional.empty(),
   in vavr it would be Some(null)
 - This can cause NPEs in VAVR if not careful!
*/
public class _34_AlternativesVavr {

    public static void main(String[] args) {
        Option<Integer> o = Option.of(1);
    }

    /*
     - The anomaly is that it allows Some(null) whereas Optional Present with null is
       not possible
     */
    void throwsNPE() {
        Option.of(1)
                .map(i -> (String) null)   // Maps to Some(null) - but in Javas Optional
                                           // this would be Empty Optional
                .map(String::toUpperCase); // Promptly throws a NPE!

        // Is this a problem? Well yes but there is a better approach in VAVR:
        Option.of(1)
                .map(i -> (String) null)
                .flatMap(s -> Option.of(s).map(String::intern)); // Note Option.of is None
                                                                 // in this case

        /*
         - Why is this better?
         - Well it is more appropriate behaviour of a monad
         - The key is that the map method should not change the computational context
         - This is what happens with:
        */
        Optional.of("a")
                .map(s -> (String) null) // In Java Computational context changes here to
                                         // Optional.empty
                .map(String::toUpperCase);



        /*
         - So in short it is more monadic
         - It is serializable
         - Has lots of convenience methods
         - Can easily convert back and forth with Java
        */

    }

}
