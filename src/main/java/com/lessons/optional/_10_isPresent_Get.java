package com.lessons.optional;

import java.util.Optional;

/*
 - get
     - Calling get() on an empty Optional results in NoSuchElementException
     - Get is considered problematic because it throws an exception if empty
     - Should not be called without a check first
     - Is a bit like a shortcut of Optional.orElseThrow
     - There are alternatives to isPresent/get depending on what you want to do such as orElse, ifPresent etc
*/
public class _10_isPresent_Get {

    public static void main(String[] args) {

        Optional<?> op = Optional.empty();
        Object o = op.get(); // NoSuchElementException!!

        // Check first
        if (op.isPresent()) {
            Object o2 = op.get();
        }
    }

}
