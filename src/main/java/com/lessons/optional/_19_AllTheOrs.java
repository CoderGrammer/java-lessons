package com.lessons.optional;

import java.util.Optional;

public class _19_AllTheOrs {

    public static void main(String[] args) {
    }

    // or
    // Return the Optional or an alternative Optional if the former is empty
    // Introduced in Java 9
    void or() {
        // Before or
        Optional<Integer> oo = Optional.of(1);
        Optional<Integer> oor = oo.map(Optional::of).orElse(Optional.of(2));

        // After or
        Optional<Integer> o = Optional.of(1);
        Optional<Integer> or = o.or(() -> Optional.of(2));
        // Use this when you want to return an Optional and you have something that yields
        // an alternative Optional
    }

    // orElse
    // Return the value or an alternative value if the Optional is empty
    void orElse() {
        Optional<Integer> o = Optional.of(1);
        Integer i = o.orElse(2);
        // Use this when you want to return a value that is not wrapped in an Optional but
        // have an alternate value too

        // What if you actually want a null?
        o.orElse(null);
    }

    // orElseGet
    // Return the value or an alternative value but from a lambda
    // Useful if the alternative is expensive to compute
    void orElseGet() {
        Optional<Integer> o = Optional.of(1);
        Integer integer = o.orElseGet(() -> 2 * 100000000 + 5);
        /*
         - Use this instead of orElse when:
             - you want to return a value or an expensive alternative value
        */
    }

    /*
     - orElseThrow
     - These methods can be used for 'defensive coding'
    */
    void orElseThrow() {
        Optional<Integer> o = Optional.of(1);
        Integer integer = o.orElseThrow(); // Throws a NoSuchElementException if empty!
        // Use this when an absence of a value i.e. an empty Optional indicates an error
    }

    // orElseThrow
    // Use when you have a custom/expensive exception to throw
    void orElseThrow2() {
        Optional<Integer> o = Optional.of(1);
        Integer integer = o.orElseThrow(() -> new IllegalStateException("Whoops!"));
        Integer integer2 = o.orElseThrow(IllegalStateException::new);
        /*
         - Use this when an absence of a value i.e. an empty Optional indicates an error
         - ...but you want a specific exception, even more so if it is expensive to
           construct
        */
    }

    void goingOverMultipleOptionals() {
        var first = Optional.empty();
        var second = Optional.empty();
        var third = Optional.empty();

        /*
         - map()
            - No good in this case because it is about transforming a value that is
            present
         - orElse()
            - No good because it is about alternate values not Optionals
         - orElseGet()
            - No good because like orElse() it is about alternate values not Optionals
        */

        // Or is the method to use
        first.or(() -> second)
                .or(() -> third)
                    .orElse("something");
        // or returns an Optional whereas orElse orElseGet return values
    }

    /*
     - Questions:
         - 1. Can you name all the or methods that must return an Optional?
         - 2. Which methods take a lambda?
         - 3. You want to get the value from an Optional if present or fetch an
           alternative value from a slow database if the Optional is empty. Do you use
          .orElse() or orElseGet()?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Can you name all the or methods that must return an Optional?
            - or() is the only one. All the other returns a value
         - 2. Which methods take a lambda?
            - or, orElseThrow(supplier), orElseGet
         - 3. You want to get the value from an Optional if present or fetch an
           alternative value from a slow database if the Optional is empty. Do you use
          .orElse() or orElseGet()?
            - orElseGet because it can take a lambda which is lazily evaluated only if
              required. If you use orElse you would need to compute the alternative
              value if even if you don't want to use it.
    */

}
