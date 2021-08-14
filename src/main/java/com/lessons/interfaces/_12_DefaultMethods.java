package com.lessons.interfaces;

public class _12_DefaultMethods {

    /*
     - We already saw default methods - Let's recap
        - Why do we need them
            - if you add methods to an interface you break source compatibility
            - this means that implementors will no longer compile
            - this means library designers cannot evolve their interfaces
            - but they can now with default methods
            - adding a default method does not break implementors
            - You effectively provide a 'default' implementation so implementors don't have to worry
         - There can be issues around resolution though - we will come to those shortly
         - They allow multiple inheritance - without state!
         - They remove the need for implementors to have empty methods
            - Although this may be a sign of bad design
    */

    interface A { default void x() { } }
    interface B { default void x() { } }

    // You are forced to override the method because there is a clash
    // class Z implements A, B {
    // }

    class X implements A, B {

        @Override
        public void x() {
            A.super.x(); // You can still call any super method you need
        }

    }

    /*
     - To understand which default method will be called there are resolution rules
         - we won't go through all of them because it won't be common
         - but we will look at some examples
    */

    // ------------------------------------------

    interface U { default void b() {}; }

    class Uc implements U {
        void a() {
            b(); // will call the one in the interface
        }
    }

    // ------------------------------------------

    interface V { default void b() {}; }

    // class Ud implements U, V {
    //     void a() {
    //         b(); // Conflict - forced to implement
    //     }
    // }

    // ------------------------------------------

    // We have overridden the b() default method
    interface W extends U {
        void b();
    }

    // Look at the error message!
    // class Ue implements W, V {
    // }

}
