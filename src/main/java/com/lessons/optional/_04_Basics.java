package com.lessons.optional;

import java.util.Optional;

public class _04_Basics {

    public static void main(String[] args) {
    }

    // No public constructor
    // You must use factory methods
    void noPublicConstructor() {
        // new Optional<String>(); // Compile error
        Optional.of("I CAN'T BE NULL");
        Optional.ofNullable(null); // Turns into Optional.empty()
        Optional.empty();
    }

    // Wildcard type gets cast
    // There is only ever 1 empty
    void internallyTypeCast() {
        Optional<String> o = Optional.empty();
    }

    interface ForceType {}
    interface Powered extends ForceType {}
    interface Manual extends ForceType {}

    /*
     - It is a parameterized type
     - There is no parametric polymorphism
     - As it is final
    */
    void parameterized() {

        class Vehicle<T extends ForceType> {
        }

        class Car extends Vehicle<Powered> {
        }

        class Bike extends Vehicle<Powered> {
        }

        /*
         - Compile error! Optional is final
         - class MaybeAddress extends Optional<MaybeAddress> { }
        */
    }

    // A method that returns Optional should never return null
    Optional<String> getString() {
        return null; // Never do this!
    }

    /*
     - Optional empty sometimes also called absent
    */
    void empty() {
        Optional.empty();
    }

    /*
     - Optional is final and immutable
     - It is value-based therefore identity sensitive ops incl reference equality (==), identity hash code, or
       synchronization should be avoided
     - Therefore it is also thread safe
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
        Optional<String> empty = Optional.ofNullable(null); // Fine. Mainly for interfacing with legacy code
    }

    /*
     - You cannot put a null inside an Optional, Optional.of(null) will generate a NPE
     - It can be empty of course e.g. Optional.ofNullable(null) but this does not store null
    */
    void storage() {
        Optional.of(null); // Throws NoSuchElementException (not NPE)
        Optional.ofNullable(null); // Equivalent to Optional.empty(), the Null is not stored
    }

    /*
     - Keep in mind that there is almost nothing to do with the empty other than knowing its empty
     - The downstream methods all do either:
         - use a value
         - do something if no value is present
         - are checks such as isEmpty
    */
    void downStreamMethods() {
        Optional.of("")
                .map(String::toLowerCase) // use the value
                .flatMap(s -> Optional.ofNullable(s.length())) // use the value
                .filter(h -> h > 4) // use the value
                .orElse(100); // do somethign if no value present
    }

}
