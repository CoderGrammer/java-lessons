package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - Optional is a 'value based class':
   https://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html
 - We discussed this is section 11 but suffice to say don't use == but prefer these
   methods like equals() etc
 - equals(), hashCode() and toString()
     - Where a value is present these methods operate on the value itself
*/
public class _23_Equality {

    public static void main(String[] args) {
        new _23_Equality().dont();
    }

    void equality() {
        Optional<String> o1 = Optional.of("abc");
        Optional<String> o2 = Optional.of("abc");
        print(o1.equals(o2));

        String s = "abc";
        print(o1.equals(s));
    }

    void _toString() {
        String s = "abc";
        Optional<String> o = Optional.of("abc");
        print(s.toString());
        print(o.toString());
    }

    void _hashCode() {
        String s = "abc";
        Optional<String> o = Optional.of("abc");
        print(s.hashCode());
        print(o.hashCode());
    }

    void dont() {
        Optional<String> o1 = Optional.of("abc");
        Optional<String> o2 = Optional.of("abc");
        print(o1 == o2); // Oops! Identity sensitive operation on value based class
    }

}
