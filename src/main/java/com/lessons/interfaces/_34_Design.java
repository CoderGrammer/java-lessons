package com.lessons.interfaces;

public class _34_Design {


    // When to create an interface?

    /*
     - When to create an interface?
     - I tend to create them when:
        - I want to treat a bunch of objects by some characteristic
            - e.g. I have cars and boats, but I want to register them, I could create a
              Vehicle interface and have a 'register' method
            - See example 1
        - Or, I need to share some functionality across multiple classes, I can create
          an interface to hold that functionality
            - See example 2
        - Where I need multiple implementations of something e.g.:
            - e.g. Connection - which may have DBConnection, SFTPConnection
            - This technique can be used to hide the implementation details from callers
            - Allows a growing number of implementations to be used seamlessly
            - You can hide implementation details
            - See example 3
        - To allow composability and maintainability some features could be extracted
          into interfaces, rather than one big class.
           - See example 4
        - Some design considerations:
            - I personally prefer small interfaces
            - Consider providing default implementation where it makes sense
    */

    // Example 1

    interface Registerable {
        void register();
    }

    class Car implements Registerable {

        @Override
        public void register() {
            System.out.println("Register car...");
        }

    }

    class Boat implements Registerable {

        @Override
        public void register() {
            System.out.println("Register boat...");
        }
    }

    // Example 2

    interface Toy {

        default void initiatePlayTime() {
            System.out.println("Get toy out");
            play();
            System.out.println("Put toy away");
        }

        void play();

    }

    class ModelCar implements Toy {

        @Override
        public void play() {
            System.out.println("Push car...");
        }
    }

    class PlayKitchen implements Toy {

        @Override
        public void play() {
            System.out.println("Make dinner...");
        }

    }

    // Example 3

    interface SearchEngine {

        void search();

    }

    class ElasticSearch implements SearchEngine {

        @Override
        public void search() {
            System.out.println("Execute search in an elastic way...");
        }
    }

    class PostgresSearch implements SearchEngine {

        @Override
        public void search() {
            System.out.println("Execute search in a postgre way...");
        }
    }

    // Example 4

    interface CreditChecks {
        default boolean checksPass() { return true; }
    }

    interface AccountCreation {
        default void createAccount() { }
    }

    class AccountService implements CreditChecks, AccountCreation {

        void setupNewAccount() {
            if (checksPass()) {
                createAccount();
            } // else error!
        }

    }

}
