package com.lessons.interfaces;

public class _13_Implementing {

    interface CanJump {

        default void jump() {
            System.out.println("Jump");
        }

        void bigJump();
    }

    // Interface extending an interface
    interface CanFly extends CanJump { }

    // Abstract classes don't need to implement interface methods
    abstract class Kangaroo implements CanJump { }

    // No need to implement default methods
    class Wallaby implements CanJump {

        @Override
        public void bigJump() {
            System.out.println("Big Jump!");
        }

    }

    // Inherits more methods than the Wallaby as CanFly extends CanJump
    class Duck implements CanFly {

        @Override
        public void bigJump() {
            System.out.println("Big Jump...");
        }
    }

}
