package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - map
     - If a value is present, apply the provided mapping function to it, and if the
       result is non-null, return an Optional describing the result
     - If present, applies the mapping
     - Returns an Optional of the result of the mapping
     - Or empty Optional if not present
     - Remember map() always returns an Optional
*/
public class _20_Map {

    public static void main(String[] args) {
        new _20_Map().convertType();
    }

    void basicExample() {
        // Optional<String> string = meth()
        //         .map(String::toUpperCase);

        // print(meth()
        //               .map(s -> s.toUpperCase()));

        print(meth()
                      .map(String::toUpperCase));
    }

    void convertType() {
        Optional<Integer> integer = meth()
                .map(Integer::parseInt);

        print(meth()
                      .map(Integer::parseInt));
    }

    static Optional<String> meth() {
        // return Optional.of("1");
        return Optional.empty();
    }

    /*
     - Questions:
         - 1. If we need an Integer can we use map() to convert a String to an Integer?
         - 2. Does map() return an Optional?
         - 3. Can you change the type of the Optional returned?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. If we need an Integer can we use map() to convert a String to an Integer?
             - Well yes and no. We can convert a present Optional of type String to an
               Integer if it is a valid integer value represented as a String. But not if
               the Optional is empty. No mapping takes place if the Optional is empty
               but the type is generic even if empty the reference type changes from
               Optional<String> to Optional<Integer>.
         - 2. Does map() return an Optional?
            - Yes always
         - 3. Can you change the type of the Optional returned?
            - You can indeed
    */

}
