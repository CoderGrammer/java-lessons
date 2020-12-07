package com.lessons.optional;

import java.util.Optional;

/*
 - map
     - If present, applies the mapping
     - Returns an Optional of the result of the mapping
     - Or empty Optional if not present
     - Remember map() always returns an Optional
*/
public class _14_Map {

    public static void main(String[] args) {
        Optional<String> s = meth()
                .map(String::toUpperCase);

        System.out.println(meth()
               .map(String::toUpperCase));
    }

    static Optional<String> meth() {
        return Optional.ofNullable("abc");
        // return Optional.ofNullable(null);
    }

}
