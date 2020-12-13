package com.lessons.optional;

import java.util.Optional;

/*
 - equals(), hashCode() and toString()
     - Where a value is present these methods operate on the value itself
*/
public class _21_Equality {

    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("abc");
        Optional<String> o2 = Optional.of("abc");
        System.out.println(o1.equals(o2));
        System.out.println(o1.toString());
    }

}
