package com.lessons.optional;

import com.lessons.optional._100_Utils.SearchResultSet;

import java.util.Objects;
import java.util.function.Supplier;

/*
 - Other ways to prevent null, some of which are still relevant
*/
public class _2_Z_PreventingNullBeforeOptional {

    public static void main(String[] args) {
        String s = null;
        // Ternary
        System.out.println(s == null ? "Nothing" : s);

        // Use external method that handles null
        Integer i = null;
        System.out.println(i.toString()); // NPE!
        System.out.println(String.valueOf(i)); // No NPE

        // Use a method to evaluate a supplier
        SearchResultSet sr = null;
        System.out.println(nullableChain(
                () -> sr.getBestMatch().getEngine().getSize().toUpperCase()));

        // Use Java assertions
        // They can be quite concise compared to if/throw checks
        // However they are often turned off in production systems
        // Use the -ea flag to enable
        String s2 = null;
        assert sr != null;

        // You can use instanceof to check the type is String and not null
        String s3 = null;
        if (s3 instanceof String) {
            // Not null
        }

        // Throw an exception
        String s4 = null;
        if (s4 == null) throw new IllegalArgumentException("Nope");

        // Use the JDK methods to check
        Objects.requireNonNull(s3);

        // Use the JDK methods to check or default
        Objects.requireNonNullElse(s4, "alternate");
    }

    // See NotNullTest.java
    public String getSomeValue() {
        // return null;
        return "abc";
    }

    static <T> String nullableChain(Supplier<T> sup) {
        try {
            return sup.get().toString();
        } catch (NullPointerException n) {
            return "";
        }
    }

}
