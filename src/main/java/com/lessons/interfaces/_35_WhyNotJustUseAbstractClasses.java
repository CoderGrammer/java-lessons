package com.lessons.interfaces;

import java.util.HashMap;
import java.util.Map;

public class _35_WhyNotJustUseAbstractClasses {

    /*
     - What is an abstract class?
        - Mix and match abstract and non-abstract methods
        - Cannot instantiate with 'new' unless anonymous
        - Must use the 'abstract' keyword
        - The opposite of interfaces
        - Main issue is that you can only inherit from 1 abstract class
        - As soon as you do that you close off the inheritance chain (apart from
          interfaces)
    */
    abstract class Home {

        void switchOnElectrics() {
            System.out.println("Switch on lights...");
        }

        abstract int getNumberOfRooms();

    }

    class MyHome extends Home {

        @Override
        int getNumberOfRooms() {
            return 3;
        }
    }

    /*
     - There is another way to extend them on the fly
     - Anonymous i.e. no name. Very similar to what we saw with interfaces
    */
    void callWithAnonymous() {
        x(new Home() {
            @Override
            int getNumberOfRooms() {
                return 0;
            }
        });
    }

    void x(Home h) { }

    /*
     - So what other differences are there?
        - Instance state!
    */
    abstract class Messages {

        StringBuilder message = new StringBuilder("This is the first part of a " +
                                                          "message:");

    }

    // Let's try to create state in an interface
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

    // e.g.

    static class Impl implements InterfaceMessages {

        StringBuilder message = new StringBuilder("This is the first part of a " +
                                                          "message:");

        @Override
        public StringBuilder getMessage() {
            return message;
        }
    }

    // Hang on! Did I lie about state?
    interface WithState {

        Map<String, Integer> studentExamScores = new HashMap<>();

        // Does this not update state?
        default void addScore(String name, Integer score) {
            studentExamScores.put(name, score);
        }

        /*
         - ...well... yes it does, but it is not instance state!
         - This state only exists once per JVM since it is static
        */
    }

}
