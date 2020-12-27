package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - What is it?
     - “…a limited mechanism for library meth return types...”
 - Why do we need it?
     - Because NPEs are very annoying and can be costly
*/
public class _07_WhyOptional {

    public static void main(String[] args) {

        // Annoying
        // String s = null;
        // print(s.length());

        // More annoying when calling an external method
        // print(meth().length());
        print(meth2()
                      .map(String::length)
                      .orElse(0));
    }

    static String meth() {
        return null;
    }

    static Optional<String> meth2() {
        // return Optional.empty();
        return Optional.of("abc");
    }

}
