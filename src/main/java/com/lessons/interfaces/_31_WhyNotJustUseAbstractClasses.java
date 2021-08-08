package com.lessons.interfaces;

public class _31_WhyNotJustUseAbstractClasses {

    /*
     - What is an abstract class?
        - Mix and match abstract and non-abstract methods
        - Cannot instantiate with 'new'
        - Must use the 'abstract' keyword
        - Main issue is that you can only inherit from 1 abstract class
        - As soon as you do that you close off the inheritance chain (apart from
          interfaces)
    */
    abstract class Home {

        void switchOnElectric() {
            System.out.println("Switch on lights...");
        }

        abstract int getNumberOfRooms();

    }

    /*
     - So what other differences are there?
        - Instance state!
    */
    abstract class Messages {

        StringBuilder message = new StringBuilder("This is the first part of a " +
                                                          "message:");

    }

    interface IMessages {

        // Automatically static!
        static StringBuilder message = new StringBuilder("This is the first part of a " +
                                                           "message:");

    }

    /*
     - Conclusions:
        - I would only use an abstract class where I need to hold state
        - If I simply want to access state I would use a getter method
    */
    abstract class AbstractMessages {

        StringBuilder message = new StringBuilder("This is the first part of a " +
                                                          "message:");

        void append(String appendage) {
            message.append(appendage);
        }

    }

    interface InterfaceMessages {

        default void append(String appendage) {
            getMessage().append(appendage);
        }

        // Get the state from the implementations
        StringBuilder getMessage();
    }

}
