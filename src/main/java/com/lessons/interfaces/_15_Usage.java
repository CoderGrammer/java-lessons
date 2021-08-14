package com.lessons.interfaces;

import java.util.ArrayList;
import java.util.List;

public class _15_Usage {


    /*
     - Implement interface
    */
    interface AirVehicle {
        void takeOff();
    }

    class Aeroplane implements AirVehicle {

        @Override
        public void takeOff() {
            System.out.println("Get to runway");
            System.out.println("Initiate take off");
        }
    }

    /*
     - You cannot create an instance of an interface
        - unless you implement it... more about that later
    */
    void instance() {
        // AirVehicle a = new AirVehicle();
    }

    /*
     - You can use them as reference types
         - What does this give you?
            - Well you can pass around references of the interface type
            - If you change the underlying implementation the impact on your code is minimal
    */
    void reference() {
        List l = new ArrayList<>();
        printList(l);
    }

    void printList(List l) {
        System.out.println("Printing...");
    }

    // You can implement an interface on the fly...
    void service(AirVehicle a) {
        System.out.println("Servicing");
    }

    // An implementing instance on the fly
    void example() {
        service(new AirVehicle() {
            @Override
            public void takeOff() {
                System.out.println("take off my weird made up hovering air vehicle");
            }
        });
    }

    // Can be replaced with a lambda - only because it is happens to be a functional interface
    void exampleWithLambda() {
        service(() -> System.out.println("take off my weird made up hovering air vehicle"));
    }

}
