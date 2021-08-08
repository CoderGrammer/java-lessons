package com.lessons.interfaces;

public interface _10_Basics {

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
     - To reduce duplication in default methods
     - Move the duplicate code to private methods
     - But not leaking them to implementors
    */
    interface BackAndForthVehicle {

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

    }

    /*
     - An interesting quirk...
     - 'protected' visibility is not allowed in interfaces
     - Deemed to offer little value for added complexity
    */
    interface LackingPrivacy {
        // protected String NAME = "CoderGrammer";
    }

    /*
     - Incorporate some utility function
     - What's the difference between static and default methods
     - Default can only be called via instances (of implementing classes)
     - Static can be called at anytime
     - Static usually implies utility functions
     - They would ideally be deterministic
     - can be private/public
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

}
