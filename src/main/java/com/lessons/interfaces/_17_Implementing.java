package com.lessons.interfaces;

public class _17_Implementing {

    interface CanJump {

        default void jump() {
            System.out.println("Jump");
        }

        void bigJump();
    }

    // No need to implement default methods
    class Wallaby implements CanJump {

        @Override
        public void bigJump() {
            System.out.println("Big Jump!");
        }

    }

    // Interface extending an interface
    interface CanFly extends CanJump {

        void fly();

    }

    // Abstract classes don't need to implement interface methods
    abstract class Kangaroo implements CanJump { }

    // Inherits more methods than the Wallaby as CanFly extends CanJump
    class Duck implements CanFly {

        @Override
        public void bigJump() {
            System.out.println("Big Jump...");
        }

        @Override
        public void fly() {

        }
    }

}
