package com.lessons.interfaces;

public interface _11_Basics {

    // They can be used as marker interfaces
    interface Animal { }

    /*
     - Why do this?
     - It allows us to signal a trait
     - The JVM/compiler can look at an object at runtime and know whether it is an
       Animal or not
    */
    class Giraffe implements Animal { }

    // A real life example is Serializable

    /*
     - They can represent some 'trait' or 'characteristic'
     - Incorporate some prescribed ability but not 'how'
    */
    interface Vehicle {

        void drive();

    }

    /*
     - The 'trait' can be more explicit
     - Describing some characteristic of the implementations
    */
    interface RequiresAdminAccess { }
    interface HasConnection { }

    /*
     - Incorporate some prescribed behaviour including 'how'
     - 'default' keyword
     - these are instance method
     - i.e. they are inherited
     - they cannot be private
     - they can be overridden
    */
    interface AirVehicle {

        default void fly() {
            startEngines();
            System.out.println("I'm flying!");
        }

        void startEngines();

    }

    /*
     - Private methods
     - Not inherited
     - Why do we need them?
     - To reduce duplication in:
        - default methods
        - static methods
     - Move the duplicate code to private methods
     - But not leaking them to implementors
     - Introduced to allow library developers to add methods to interfaces and still ensure compatibility
        - i.e. existing implementors don't need to implement new methods all of a sudden
        - static methods won't do because:
            - a. they are static implying utility methods
            - b. they cannot access instance methods
    */
    interface BackAndForthVehicle {

        // Private method to dedup default methods

        default void forward() {
            aboutToMoveWarning();
            System.out.println("I'm going forward!");
        }

        default void back() {
            aboutToMoveWarning();
            System.out.println("I'm going backwards!");
        }

        private void aboutToMoveWarning() {
            System.out.println("About to move...");
        }

        // Private method to dedup static methods

        static void printName(String name) {
            print(name);
        }

        static void printNum(Integer num) {
            print(num);
        }

        private static void print(Object o) {
            System.out.println(o);
        }

    }

    /*
     - Static methods are allowed in interfaces
         - Incorporate some utility function
         - Reduces the need for utility classes holding only static methods
         - What's the difference between static and default methods
         - Default can only be called via instances (of implementing classes)
         - Static can be called at anytime
         - Static usually implies utility functions
         - They would ideally be deterministic
         - Can be private/public
    */
    interface RentalCalculator {

        static int add(int x, int y) {
            return x + y;
        }

    }

    /*
     - Method attributes
         - public is redundant
         - abstract is redundant
    */
    interface Car {
        public abstract void drive();
        // Cannot combine final with abstract
        // public abstract final void reverse();
        // ... doesn't really make sense since 'final' implies the 'final' implementation
    }

    /*
     - So we have seen that interfaces can contain:
        - abstract methods
        - static methods
        - constants
        - default methods
     - When you implement an interface you must implement all abstract methods
     - But abstract classes don't need to
     - Interfaces names can be used in the same way class types can be used
    */



}
