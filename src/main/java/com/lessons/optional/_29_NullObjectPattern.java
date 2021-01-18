package com.lessons.optional;

import java.util.Optional;

import static com.lessons.optional._99_Utils.print;

/*
 - Example special case of the Strategy Pattern
 - When you delegate behaviour to a type such asking a Bike object to Ride, well when you
   ask a Null object to Ride it would simply do nothing
 - Lets look at an example!
 - The Null object can be created as a singleton (but remember Optional.empty() is also
   effectively a singleton)
 - When to use:
     - If your client is fetching member values then use Optional or nothing in the
       case of bean props
     - If your client is delegating behaviour to the object it may be useful to use the
       Null object pattern to save them the work
     - If your object was more of the bean variety then what would you return from you
       Null object? Optionals? More nulls? This is why I would suggest not using for
       bean type classes
*/
public class _29_NullObjectPattern {

    public static void main(String[] args) {
        new _29_NullObjectPattern().demo();
    }

    interface Vehicle {
        void move();
    }

    static class Bike implements Vehicle {

        @Override
        public void move() {
            print("Ride");
        }
    }

    static class Car implements Vehicle {

        @Override
        public void move() {
            print("Drive");
        }
    }

    static class Null implements Vehicle {

        @Override
        public void move() {

        }

    }

    private static final Null NULL = new Null();

    /*
     - With the Null object pattern callers can comfortably call methods on the object
    */

   private Vehicle getVehicleForUser(String userId) {
       switch (userId) {
           case "0":
               return new Bike();
           case "1":
               return new Car();
           default:
               return NULL;
//                return null;
       }
   }

    // /*
    //  - With Optional they will have to handle the absent case
    // */
    // private Optional<Vehicle> getVehicleForUser(String userId) {
    //     switch (userId) {
    //         case "0":
    //             return Optional.of(new Bike());
    //         case "1":
    //             return Optional.of(new Car());
    //         default:
    //             return Optional.empty();
    //     }
    // }

    public void demo() {
       // NUll Object pattern
       getVehicleForUser("0").move();
       getVehicleForUser("1").move();
       getVehicleForUser("2").move();

        // Optional approach
        // getVehicleForUser("0").ifPresent(Vehicle::move);
        // getVehicleForUser("1").ifPresent(Vehicle::move);
        // getVehicleForUser("2").ifPresent(Vehicle::move);
    }

}
