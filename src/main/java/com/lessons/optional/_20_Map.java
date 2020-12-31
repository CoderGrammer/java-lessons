package com.lessons.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static com.lessons.optional._99_Utils.print;

/*
 - map
     - If present, applies the mapping
     - Returns an Optional of the result of the mapping
     - Or empty Optional if not present
     - Remember map() always returns an Optional
*/
public class _20_Map {

    public static void main(String[] args) {
        Optional<String> s = meth()
                .map(String::toUpperCase);

        print(meth()
               .map(String::toUpperCase));
    }

    static Optional<String> meth() {
        return Optional.ofNullable("abc");
        // return Optional.ofNullable(null);
    }

}
