package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - get
     - Returns the value if its present
     - Calling it on an empty Optional results in NoSuchElementException
     - "I think calling this method "get()" was our biggest API mistake in Java 8"
       Brian Goetz
     - There are even calls to deprecate it
     - Looks simple and safe, but isn't - it might throw an exception
     - orElseThrow has a side effect but its clear from the name
     - Get is considered problematic because it throws an exception if empty
     - Should not be called without a check first by calling isPresent
     - Is a bit like a shortcut of Optional.orElseThrow
     - There are alternatives to isPresent/get depending on what you want to do such as
       orElse, ifPresent etc
*/
public class _15_IsPresent_Get {

    public static void main(String[] args) {

        Optional<?> op = Optional.empty();
        Object o = op.get(); // NoSuchElementException!!

        // Check first
        if (op.isPresent()) {
            Object o2 = op.get();
        }

        Optional<String> value = getValue();
        // now you want the value or empty string

        // When you have an alternate value
        String s;
        if (value.isPresent()) {
            s = value.get();
        } else {
            s = "";
        }

        s = value.orElse("");

        // When you want to print or throw exception if there is no value
        if (value.isPresent()) {
            print(value.get());
        } else {
            throw new RuntimeException("Error");
        }

        value.orElseThrow(() -> new RuntimeException("Error"));
    }

    static Optional<String> getValue() {
        return Optional.empty();
    }

}

    /*
     - Questions:
         - 1. When should you use .isPresent()/.get()?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. When should you use .isPresent()/.get()?
             - Probably never. There is a better method out there for you e.g. orElse
             (null), orElseThrow(), orElseGet()... etc
    */