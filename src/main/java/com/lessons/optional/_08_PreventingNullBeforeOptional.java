package com.lessons.optional;

import com.lessons.optional._99_Utils.SearchResultSet;

import java.util.Objects;
import java.util.function.Supplier;

import static com.lessons.optional._99_Utils.print;

/*
 - Other ways to prevent null, some of which are still relevant
*/
public class _08_PreventingNullBeforeOptional {

    public static void main(String[] args) {
        new _08_PreventingNullBeforeOptional();
    }

    void ternary() {
        String s = null;
        // Ternary
        print(s == null ? "Nothing" : s);
    }

    void method() {
        // Use a method that handles null
        Integer i = null;
        print(i.toString()); // NPE!
        print(String.valueOf(i)); // No NPE
    }

    void tryCatch() {
        /*
         - Use a try catch to catch the runtime exception
         - Not considered a great idea to use exceptions for flow control
         - Generally not considered ideal to catch Runtime exceptions e.g. the null
           could have come from somewhere else
         - There are more expressive ways handle this
        */
        String t = null;
        try {
            // // NPE could come from somewhere else
            // Integer in = null;
            // int in2 = in.intValue();

            print(t.toUpperCase());
        } catch (NullPointerException n) {
            print("NO VALUE");
        }
    }

    void supplier() {
        /*
         - Use a method to evaluate a supplier
         - Good for method chains
        */
        SearchResultSet sr = null;
        print(nullableChain(
                () -> sr.getBestMatch().getEngine().getSize().toUpperCase()));
    }

    void assertions() {
        /*
         - Use Java assertions
         - They can be quite concise compared to if/throw checks
         - However they are often turned off in production systems
         - Use the -ea flag to enable
        */
        String s2 = null;
        assert s2 != null;
    }

    void instanceOf() {
        // You can use instanceof to check the type is String and not null
        String s3 = null;
        if (s3 instanceof String) {
            // Not null
        }
    }

    void exception() {
        // Defensively throw an exception manually
        String s4 = null;
        if (s4 == null) throw new IllegalArgumentException("Nope");
    }

    void objects() {
        String s = null;
        // Use the JDK methods to check
        Objects.requireNonNull(s);

        // Use the JDK methods to check or default
        Objects.requireNonNullElse(s, "alternate");

        /*
         - Check if its null in a streaming context
         - Why do we need this?
         - Well in a stream it can be used as a Predicate: Objects::isNull
        */
        Objects.isNull(null);

        // Opposite of the previous method
        Objects.nonNull(null);
    }

    static class UnnecessaryNullCheck {

        void a() {
            b("never null");
        }

        void b(String s) {
            /*
             - The compiler knows that this can never be null
             - The JIT compiler uses 'uncommon trap' to remove these speeding up the code
             - It can also reinstate it if it discovers that this is indeed required
             - Java -> Compile -> Bytecode -> JIT Compile -> Machine code
            */
            if (s == null) {
                return;
            }
            print(s);
        }

    }

    /*
     - Use a unit test
     - See NotNullTest.java
    */
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
