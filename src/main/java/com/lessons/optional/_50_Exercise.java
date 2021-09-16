package com.lessons.optional;

import java.util.Optional;

/*
 - This class holds the code for the exercise tasks
 - See the code below and then see the tasks further below
*/
public class _50_Exercise {

    EmployeeService service = new EmployeeService();

    /*
     - A service with some slightly dodgy looking methods...
    */
    static class EmployeeService {

        Optional<String> getRandomEmployeeName() {
            return Optional.of("Joe");
        }

        Optional<Integer> getRandomEmployeeAge() {
            return Optional.of(32);
        }

        String getRandomEmployeeSurname() {
            return null;
        }

    }

    /*
     - This method just allows you to run your task methods
    */
    public static void main(String[] args) {
        var e = new _50_Exercise();
        e.printRandomEmployeeNameOrMissing();
        e.roundRandomEmployeeAgeDownAndPrintOrZero();
        e.printRandomEmployeeSurnameOrMissing();
    }

    /*
     - -----------------------------------------------------
     - See tasks 1, 2 and 3 below
     - -----------------------------------------------------
    */

    /*
     - Implement the following methods
     - The first one is done for you as an example...
     - Note, there may be more than one valid solution for some tasks
    */

    /*
     - 1.
     - Print the random employees name
     - If it is empty print the string MISSING
    */
    void printRandomEmployeeNameOrMissing() {
        Optional<String> empName = service.getRandomEmployeeName();
        System.out.println(empName.orElse("MISSING"));
    }

    /*
     - 2.
     - Get the random employee age
     - If present add 10 to it
     - If empty print zero
    */
    void roundRandomEmployeeAgeDownAndPrintOrZero() {
        Optional<Integer> empAge = service.getRandomEmployeeAge();
        // Implement your code solution here:
    }

    /*
     - 3.
     - Get the random employee surname
     - If it is not null print it
     - If it is null print MISSING
    */
    void printRandomEmployeeSurnameOrMissing() {
        String empSurname = service.getRandomEmployeeSurname();
        // Implement your code solution here:
    }

}
