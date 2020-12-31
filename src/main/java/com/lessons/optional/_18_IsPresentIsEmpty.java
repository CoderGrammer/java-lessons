package com.lessons.optional;

import com.lessons.optional._99_Utils.Employee;

import java.util.List;
import java.util.Optional;
import static com.lessons.optional._99_Utils.print;

public class _18_IsPresentIsEmpty {

    /*
     - More useful for information as there are useful other methods for actually
       processing the value
    */
    public static void main(String[] args) {
        Optional<Integer> o = Optional.of(1);
        print(o.isPresent()); // True
        print(o.isEmpty()); // False - Only added in Java 11!

        /*
         - Why was isEmpty() introduced when we don't have isNotEmpty() on collections
         - Well presence or absence is fundamental to Optional whereas presence or
           absence is not fundamental to collections
        */

        /*
         - What are the these methods useful for?
         - You can just use alternatives when you need to operate on the value
         - If you need to do something later where you don't need the value they can be
           useful
        */
        o.ifPresent(g -> print(g));
        // do a bunch of stuff...
        // later on we also care if it was empty
        if (o.isEmpty()) {
            // Do some operations that are useful if it is empty
            print("Hey just wanted to let you know that was no actual value...");
        }

        if (o.isPresent()) { // could also do this with ifPresent...
            print("Hey just wanted to let you know that was no actual value...");
        }

    }

    /*
     - Another case where these methods are useful is when you simply want to know
       if something was present or not e.g. does this employee have a middle name.
     - We don't care what the middle name is:
    */
    boolean hasMiddleName(Employee e) {
        return e.getMiddleName().isPresent();
    }

    boolean hasNoMiddleName(Employee e) {
        // return e.getMiddleName().orElse(null) == null;
        // return !e.getMiddleName().isPresent();
        // return e.getMiddleName().map(g -> Boolean.TRUE).orElse(Boolean.FALSE);
        return e.getMiddleName().isEmpty();
    }

    /*
     - Questions:
         - 1. These methods should be avoided for better alternatives. True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. These methods should be avoided for better alternatives. True/False
             - False they are perfectly useful when you want to know if the optional
               was present or empty
    */

}
