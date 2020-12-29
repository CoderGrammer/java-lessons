package com.lessons.optional;

import java.util.Optional;

public class _11_OptionalBasics {

    public static void main(String[] args) {
        new _11_OptionalBasics().noPublicConstructor();
    }

    // No public constructor
    // You must use factory methods
    void noPublicConstructor() {
        // new Optional<String>(); // Compile error
        Optional<String> s = Optional.of("I CAN'T BE NULL");// Present
        // Mainly for interaction with legacy systems
        Optional.ofNullable(null); // Turns into Optional.empty()
        Optional.empty();
    }

    // Wildcard type gets cast
    // Internally: 'private static final Optional<?> EMPTY = new Optional<>();'
    // There is only ever 1 empty
    void internallyTypeCast() {
        Optional<String> o = Optional.empty();
    }

    // Example method that returns Optional should never return null
    Optional<String> getString() {
        return null; // Never do this!
        // Violates any reasonable expectation showing you have considered null!
    }

    /*
     - Optional empty sometimes also called absent
    */
    void empty() {
        Optional.empty();
    }

    /*
     - Optional is final and immutable
     - Therefore it is also thread safe
     - It is value-based therefore identity sensitive ops incl reference equality (==),
       identity hash code, or synchronization should be avoided
     - Why? Because in a future release value based classes may have some internal
       optimization that cause such operations to behave in ways you don't expect
     - "A program may produce unpredictable results if it attempts to distinguish two
       references to equal values of a value-based class"
     - Optional is not serializable so don’t use it as bean properties
    */
    void structure() {
        Optional.empty();
    }

    // Has only two states Present or Empty
    void twoStates() {
        Optional<String> empty = Optional.empty();
        Optional<String> present = Optional.of("present");
    }

    // Should usually be used as a return type
    void usage() {
        Optional<String> empty = Optional.empty();
        Optional<String> present = Optional.of("present");
    }

    void constructing() {
        Optional<String> present = Optional.of("No Nulls pls");
        Optional<String> error = Optional.of(null); // NPE
        Optional<String> empty = Optional.ofNullable(null); // Fine. Mainly for
        // interfacing with legacy code
    }

    /*
     - You cannot put a null inside an Optional, Optional.of(null) will generate a NPE
     - It can be empty of course e.g. Optional.ofNullable(null) but this does not store
       null
    */
    void storage() {
        Optional.of(null); // Throws NullPointerException
        Optional.ofNullable(null); // Equivalent to Optional.empty(), the Null is not
        // stored
    }

    /*
     - Keep in mind that there is almost nothing to do with the empty other than knowing
       its empty
     - The downstream methods all do either:
         - use a value
         - do something if no value is present
         - are checks such as isEmpty
    */
    void downStreamMethods() {
        Optional.<String>empty()
        // Optional.of("ABC")
                .map(String::toLowerCase) // use the value
                .flatMap(s -> Optional.ofNullable(s.length())) // use the value
                .filter(h -> h > 4) // use the value
                .orElse(100); // do something if no value present
    }

    interface ForceType {}
    interface Powered extends ForceType {}
    interface Manual extends ForceType {}

    /*
     - Polymorphism is where classes are related by inheritance
     - A top level reference type can point to any of its subtypes
     - Optional is a parameterized type
     - With parameterized types you often get Parametric Polymorphism
         - You can reduce duplication but get type safety
         - Highly expressive
     - You cannot extend Optional to have your own parametric polymorphism with Optional
     - As it is final
    */
    void parameterized() {

        class Vehicle<T extends ForceType> {
        }

        class Car extends Vehicle<Powered> {
        }

        class Bike extends Vehicle<Manual> {
        }

        // Compile error! Optional is final
        // class MaybeAddress extends Optional<MaybeAddress> { }
    }

    /*
     - Questions:
         - 1. Can you create an Optional using its constructor?
         - 2. Can you store null in an Optional?
         - 3. Can you implement your own parametric polymorphism with Optional?
         - 4. If you have no suitable value then return null instead of Optional.empty
              () to reduce memory overhead? True/False
         - 5. Optional.of(null) is the best way to construct an empty Optional? True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Can you create an Optional using its constructor?
            - Nope, there are no public constructors. Use factory methods.
         - 2. Can you store null in an Optional?
            - Nope, an Optional.ofNullable(null) becomes Optional.empty() but does not
              store null
         - 3. Can you implement your own parametric polymorphism with Optional?
            - Nope, because Optional is final so you cannot extend it
         - 4. If you have no suitable value then return null instead of Optional.empty
              () to reduce memory overhead? True/False
            - False! No! Never. Any method returning Optional should never return null!
         - 5. Optional.of(null) is the best way to construct an empty Optional? True/False
            - No this throws an exception! Use Optional.empty() or
              Optional.ofNullable(null)
    */

}

