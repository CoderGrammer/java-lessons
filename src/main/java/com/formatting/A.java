package com.formatting;

import java.util.Objects;
import java.util.Optional;

public class A {

    public static void main(String[] args) {
        String s = null;
        String y = Objects.requireNonNull(s, "s must not be null");
        // String y = Optional.ofNullable(s).orElseThrow(() -> new RuntimeException("s Must not be null"));

    }

}
